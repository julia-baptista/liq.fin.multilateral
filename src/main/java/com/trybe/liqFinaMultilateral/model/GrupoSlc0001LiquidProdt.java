package com.trybe.liqFinaMultilateral.model;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "Grupo_SLC0001_LiquidProdt")
@Entity(name = "TB_Grupo_SLC0001_LiquidProdt")
public class GrupoSlc0001LiquidProdt {

  @Id
  @Column(name = "IdentdLinhaBilat")
  private String identdLinhaBilat;

  @Column(name = "TpDeb_Cred")
  private String tpDebCred;

  @Column(name = "ISPBIFCredtd")
  private Long ispbIfCredtd;

  @Column(name = "ISPBIFDebtd")
  private Long ispbIfDebtd;

  @Column(name = "VlrLanc")
  private BigDecimal vlrLanc;

  @Column(name = "CNPJNLiqdantDebtd")
  private String cnpjLiqdantDebtd;

  @Column(name = "NomCliDebtd")
  private String nomCliDebtd;

  @Column(name = "CNPJNLiqdantCredtd")
  private String cnpjNLiqdantCredtd;

  @Column(name = "NomCliCredtd")
  private String nomCliCredtd;

  @Column(name = "TpTranscSLC")
  private String tpTranscSLC;

  @ManyToOne
  @JoinColumn(name = "codProdt")
  private GrupoSlc0001Prodt grupoSlc0001Prodt;

  @XmlElement(name = "IdentdLinhaBilat")
  public String getIdentdLinhaBilat() {
    return identdLinhaBilat;
  }

  @XmlElement(name = "TpDeb_Cred")
  public String getTpDebCred() {
    return tpDebCred;
  }

  @XmlElement(name = "ISPBIFCredtd")
  public Long getIspbIfCredtd() {
    return ispbIfCredtd;
  }

  @XmlElement(name = "ISPBIFDebtd")
  public Long getIspbIfDebtd() {
    return ispbIfDebtd;
  }

  @XmlElement(name = "VlrLanc")
  public BigDecimal getVlrLanc() {
    return vlrLanc;
  }

  @XmlElement(name = "CNPJNLiqdantDebtd")
  public String getCnpjLiqdantDebtd() {
    return cnpjLiqdantDebtd;
  }

  @XmlElement(name = "NomCliDebtd")
  public String getNomCliDebtd() {
    return nomCliDebtd;
  }

  @XmlElement(name = "CNPJNLiqdantCredtd")
  public String getCnpjNLiqdantCredtd() {
    return cnpjNLiqdantCredtd;
  }

  @XmlElement(name = "NomCliCredtd")
  public String getNomCliCredtd() {
    return nomCliCredtd;
  }

  @XmlElement(name = "TpTranscSLC")
  public String getTpTranscSLC() {
    return tpTranscSLC;
  }

  public void setIdentdLinhaBilat(String identdLinhaBilat) {
    this.identdLinhaBilat = identdLinhaBilat;
  }

  public void setTpDebCred(String tpDebCred) {
    this.tpDebCred = tpDebCred;
  }

  public void setIspbIfCredtd(Long ispbIfCredtd) {
    this.ispbIfCredtd = ispbIfCredtd;
  }

  public void setIspbIfDebtd(Long ispbIfDebtd) {
    this.ispbIfDebtd = ispbIfDebtd;
  }

  public void setVlrLanc(BigDecimal vlrLanc) {
    this.vlrLanc = vlrLanc;
  }

  public void setCnpjLiqdantDebtd(String cnpjLiqdantDebtd) {
    this.cnpjLiqdantDebtd = cnpjLiqdantDebtd;
  }

  public void setNomCliDebtd(String nomCliDebtd) {
    this.nomCliDebtd = nomCliDebtd;
  }

  public void setCnpjNLiqdantCredtd(String cnpjNLiqdantCredtd) {
    this.cnpjNLiqdantCredtd = cnpjNLiqdantCredtd;
  }

  public void setNomCliCredtd(String nomCliCredtd) {
    this.nomCliCredtd = nomCliCredtd;
  }

  public void setTpTranscSLC(String tpTranscSLC) {
    this.tpTranscSLC = tpTranscSLC;
  }

  public GrupoSlc0001Prodt getGrupoSlc0001Prodt() {
    return grupoSlc0001Prodt;
  }

  public void setGrupoSlc0001Prodt(GrupoSlc0001Prodt grupoSlc0001Prodt) {
    this.grupoSlc0001Prodt = grupoSlc0001Prodt;
  }
}
