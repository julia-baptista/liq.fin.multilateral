package com.trybe.liqFinaMultilateral.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Grupo_Seq")
@Entity(name = "TB_Grupo_Seq")
public class GrupoSeq {

  @Id
  @Column(name = "NumSeq")
  private Integer numSeq;

  @Column(name = "IndrCont")
  private String indrCont;

  @OneToOne(mappedBy = "grupoSeq", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Bcmsg bcmsg;

  @XmlElement(name = "NumSeq")
  public Integer getNumSeq() {
    return numSeq;
  }

  @XmlElement(name = "IndrCont")
  public String getIndrCont() {
    return indrCont;
  }

  public void setNumSeq(Integer numSeq) {
    this.numSeq = numSeq;
  }

  public void setIndrCont(String indrCont) {
    this.indrCont = indrCont;
  }

  public Bcmsg getBcmsg() {
    return bcmsg;
  }

  public void setBcmsg(Bcmsg bcmsg) {
    this.bcmsg = bcmsg;
  }
}
