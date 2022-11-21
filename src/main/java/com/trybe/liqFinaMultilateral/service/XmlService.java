package com.trybe.liqFinaMultilateral.service;

import com.trybe.liqFinaMultilateral.dtos.*;
import com.trybe.liqFinaMultilateral.model.*;
import com.trybe.liqFinaMultilateral.exception.ErroInesperadoException;
import com.trybe.liqFinaMultilateral.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class XmlService {

  @Autowired
  private DocRepository docRepo;

  @Autowired
  private BcmsgRepository bcmsgRepo;

  @Autowired
  private GrupoSeqRepository grupoSeqRepo;

  @Autowired
  private SismsgRepository sismsgRepo;

  @Autowired
  private Slc0001Repository slc0001Repo;

  @Autowired
  private GrupoSLC0001LiquidRepository grupoSLC0001LiquidRepo;

  @Autowired
  private GrupoSlc0001ProdtRepository grupoProdtRepo;

  @Autowired
  private GrupoSlc0001LiquidProdtRepository liquidProdtRepo;

  public void loadXml(Doc doc) {
    docRepo.save(doc);

    doc.getBcmsg().getGrupoSeq().setBcmsg(doc.getBcmsg());
    grupoSeqRepo.save(doc.getBcmsg().getGrupoSeq());

    doc.getBcmsg().setDoc(doc);
    bcmsgRepo.save(doc.getBcmsg());

    doc.getSismsg().setDoc(doc);
    sismsgRepo.save(doc.getSismsg());

    grupoSLC0001LiquidRepo.save(doc.getSismsg().getSlc0001().getGrupoSlc0001Liquid());

    doc.getSismsg().getSlc0001().setSismsg(doc.getSismsg());
    slc0001Repo.save(doc.getSismsg().getSlc0001());

    doc.getSismsg().getSlc0001().getGrupoSlc0001Liquid().getGrupoSlc0001Prodt().stream()
        .forEach(itemProdt -> {
          itemProdt.setGrupoSLC0001Liquid(doc.getSismsg().getSlc0001().getGrupoSlc0001Liquid());
          grupoProdtRepo.save(itemProdt);

          itemProdt.getGrupoSlc0001LiquidProdt().stream().forEach(item -> {
            item.setGrupoSlc0001Prodt(itemProdt);
            liquidProdtRepo.save(item);
          });
        });
  }

  /**
   * Listar.
   */
  @Transactional
  public DocDTO listar() {
    try {
      Doc doc = docRepo.findAll().get(0);

      Bcmsg bcmsg = doc.getBcmsg();
      GrupoSeq grupoSeq = bcmsg.getGrupoSeq();
      GrupoSeqDTO grupoSeqDTO = createGrupoSeqDTO(grupoSeq);

      BcmsgDTO bcmsDto = createBcmsgDTO(bcmsg, grupoSeqDTO);

      Sismsg sismsg = doc.getSismsg();
      Slc0001 slc0001 = sismsg.getSlc0001();
      GrupoSLC0001Liquid grupoSlc0001Liquid = slc0001.getGrupoSlc0001Liquid();

      List<GrupoSlc0001ProdtDTO> gruposSlc0001ProdtDTO = new ArrayList<>();

      grupoSlc0001Liquid.getGrupoSlc0001Prodt().stream().forEach(itemGrupo -> {
        List<GrupoSlc0001LiquidProdtDTO> gruposSlc0001LiquidProdt = new ArrayList<>();
        itemGrupo.getGrupoSlc0001LiquidProdt().stream().forEach(itemDetail -> {
          GrupoSlc0001LiquidProdtDTO dto = createGrupoSlc0001LiquidProdtDTO(itemDetail);
          gruposSlc0001LiquidProdt.add(dto);
        });
        GrupoSlc0001ProdtDTO dto = createGrupoSlc0001ProdtDTO(itemGrupo, gruposSlc0001LiquidProdt);
        gruposSlc0001ProdtDTO.add(dto);
      });

      GrupoSLC0001LiquidDTO grupoSLC0001LiquidDTO =
          createGrupoSLC0001LiquidDTO(grupoSlc0001Liquid, gruposSlc0001ProdtDTO);

      Slc0001DTO slc0001DTO = createSlc0001DTO(slc0001, grupoSLC0001LiquidDTO);

      SismsgDTO sismsgDTO = SismsgDTO.builder().slc0001DTO(slc0001DTO).build();

      DocDTO docDTO = DocDTO.builder().bcmsgDTO(bcmsDto).sismsgDTO(sismsgDTO).build();

      return docDTO;
    } catch (Exception e) {
      throw new ErroInesperadoException();
    }
  }

  private Slc0001DTO createSlc0001DTO(Slc0001 slc0001,
      GrupoSLC0001LiquidDTO grupoSLC0001LiquidDTO) {
    return Slc0001DTO.builder().codMsg(slc0001.getCodMsg()).dtHrSLC(slc0001.getDtHrSLC())
        .dtMovto(slc0001.getDtMovto()).ispbif(slc0001.getIspbif())
        .numCtrlSLC(slc0001.getNumCtrlSLC()).tpInf(slc0001.getTpInf())
        .grupoSlc0001LiquidDTO(grupoSLC0001LiquidDTO).build();
  }

  private GrupoSLC0001LiquidDTO createGrupoSLC0001LiquidDTO(GrupoSLC0001Liquid grupoSlc0001Liquid,
      List<GrupoSlc0001ProdtDTO> gruposSlc0001ProdtDTO) {
    return GrupoSLC0001LiquidDTO.builder().dtLiquid(grupoSlc0001Liquid.getDtLiquid())
        .numSeqCicloLiquid(grupoSlc0001Liquid.getNumSeqCicloLiquid())
        .gruposSlc0001ProdtDTO(gruposSlc0001ProdtDTO).build();
  }

  private GrupoSlc0001ProdtDTO createGrupoSlc0001ProdtDTO(GrupoSlc0001Prodt itemGrupo,
      List<GrupoSlc0001LiquidProdtDTO> gruposSlc0001LiquidProdt) {
    return GrupoSlc0001ProdtDTO.builder().codProdt(itemGrupo.getCodProdt())
        .gruposSlc0001LiquidProdt(gruposSlc0001LiquidProdt).build();
  }

  private GrupoSlc0001LiquidProdtDTO createGrupoSlc0001LiquidProdtDTO(
      GrupoSlc0001LiquidProdt itemDetail) {
    return GrupoSlc0001LiquidProdtDTO.builder().cnpjLiqdantDebtd(itemDetail.getCnpjLiqdantDebtd())
        .cnpjNLiqdantCredtd(itemDetail.getCnpjNLiqdantCredtd())
        .identdLinhaBilat(itemDetail.getIdentdLinhaBilat())
        .ispbIfCredtd(itemDetail.getIspbIfCredtd()).ispbIfDebtd(itemDetail.getIspbIfDebtd())
        .nomCliCredtd(itemDetail.getNomCliCredtd()).nomCliDebtd(itemDetail.getNomCliDebtd())
        .tpDebCred(itemDetail.getTpDebCred()).tpTranscSLC(itemDetail.getTpTranscSLC())
        .vlrLanc(itemDetail.getVlrLanc()).build();
  }

  private BcmsgDTO createBcmsgDTO(Bcmsg bcmsg, GrupoSeqDTO grupoSeqDTO) {
    return BcmsgDTO.builder().domSist(bcmsg.getDomSist())
        .identdDestinatario(bcmsg.getIdentdDestinatario()).identdEmissor(bcmsg.getIdentdEmissor())
        .nuOp(bcmsg.getNuOp()).grupoSeqDTO(grupoSeqDTO).build();
  }

  private GrupoSeqDTO createGrupoSeqDTO(GrupoSeq grupoSeq) {
    return GrupoSeqDTO.builder().numSeq(grupoSeq.getNumSeq()).indrCont(grupoSeq.getIndrCont())
        .build();
  }
}
