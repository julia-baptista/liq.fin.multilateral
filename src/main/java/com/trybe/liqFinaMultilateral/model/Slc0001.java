package com.trybe.liqFinaMultilateral.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "SLC0001")
@Entity(name = "TB_SLC0001")
public class Slc0001 {

  @Id
  @Column(name = "CodMsg")
  private String codMsg;

  @Column(name = "NumCtrlSLC")
  private String numCtrlSLC;

  @Column(name = "ISPBIF")
  private Integer ispbif;

  @Column(name = "TpInf")
  private String tpInf;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "NumSeqCicloLiquid")
  private GrupoSLC0001Liquid grupoSlc0001Liquid;

  @Column(name = "DtHrSLC")
  private Date dtHrSLC;

  @Column(name = "DtMovto")
  private String dtMovto;

  @OneToOne(mappedBy = "slc0001", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Sismsg sismsg;

  @XmlElement(name = "CodMsg")
  public String getCodMsg() {
    return codMsg;
  }

  @XmlElement(name = "NumCtrlSLC")
  public String getNumCtrlSLC() {
    return numCtrlSLC;
  }

  @XmlElement(name = "ISPBIF")
  public Integer getIspbif() {
    return ispbif;
  }

  @XmlElement(name = "TpInf")
  public String getTpInf() {
    return tpInf;
  }

  @XmlElement(name = "Grupo_SLC0001_Liquid")
  public GrupoSLC0001Liquid getGrupoSlc0001Liquid() {
    return grupoSlc0001Liquid;
  }

  @XmlElement(name = "DtHrSLC")
  public Date getDtHrSLC() {
    return dtHrSLC;
  }

  @XmlElement(name = "DtMovto")
  public String getDtMovto() {
    return dtMovto;
  }

  public void setCodMsg(String codMsg) {
    this.codMsg = codMsg;
  }

  public void setNumCtrlSLC(String numCtrlSLC) {
    this.numCtrlSLC = numCtrlSLC;
  }

  public void setIspbif(Integer ispbif) {
    this.ispbif = ispbif;
  }

  public void setTpInf(String tpInf) {
    this.tpInf = tpInf;
  }

  public void setGrupoSlc0001Liquid(GrupoSLC0001Liquid grupoSlc0001Liquid) {
    this.grupoSlc0001Liquid = grupoSlc0001Liquid;
  }

  public void setDtHrSLC(Date dtHrSLC) {
    this.dtHrSLC = dtHrSLC;
  }

  public void setDtMovto(String dtMovto) {
    this.dtMovto = dtMovto;
  }

  public Sismsg getSismsg() {
    return sismsg;
  }

  public void setSismsg(Sismsg sismsg) {
    this.sismsg = sismsg;
  }
}
