package com.trybe.liqFinaMultilateral.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BCMSG")
@Entity(name = "TB_BCMSG")
public class Bcmsg {

  @Id
  @Column(name = "NuOp")
  private Double nuOp;

  @Column(name = "IdentdEmissor")
  private Integer identdEmissor;

  @Column(name = "IdentdDestinatario")
  private Integer identdDestinatario;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "numSeq")
  private GrupoSeq grupoSeq;

  @Column(name = "DomSist")
  private String domSist;

  @OneToOne(mappedBy = "bcmsg", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Doc doc;

  @XmlElement(name = "IdentdEmissor")
  public Integer getIdentdEmissor() {
    return identdEmissor;
  }

  @XmlElement(name = "IdentdDestinatario")
  public Integer getIdentdDestinatario() {
    return identdDestinatario;
  }

  @XmlElement(name = "Grupo_Seq")
  public GrupoSeq getGrupoSeq() {
    return grupoSeq;
  }

  @XmlElement(name = "DomSist")
  public String getDomSist() {
    return domSist;
  }

  @XmlElement(name = "NUOp")
  public Double getNuOp() {
    return nuOp;
  }

  public void setIdentdEmissor(Integer identdEmissor) {
    this.identdEmissor = identdEmissor;
  }

  public void setIdentdDestinatario(Integer identdDestinatario) {
    this.identdDestinatario = identdDestinatario;
  }

  public void setGrupoSeq(GrupoSeq grupoSeq) {
    this.grupoSeq = grupoSeq;
  }

  public void setDomSist(String domSist) {
    this.domSist = domSist;
  }

  public void setNuOp(Double nuOp) {
    this.nuOp = nuOp;
  }

  public Doc getDoc() {
    return doc;
  }

  public void setDoc(Doc doc) {
    this.doc = doc;
  }
}
