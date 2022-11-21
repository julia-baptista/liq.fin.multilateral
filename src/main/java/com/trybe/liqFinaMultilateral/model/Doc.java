package com.trybe.liqFinaMultilateral.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DOC")
@Entity(name = "TB_DOC")
public class Doc {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JoinColumn(name = "bcmsg_id")
  @OneToOne(fetch = FetchType.LAZY)
  private Bcmsg bcmsg;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sismsg_id")
  private Sismsg sismsg;

  @XmlElement(name = "BCMSG")
  public Bcmsg getBcmsg() {
    return bcmsg;
  }

  @XmlElement(name = "SISMSG")
  public Sismsg getSismsg() {
    return sismsg;
  }

  public void setBcmsg(Bcmsg bcmsg) {
    this.bcmsg = bcmsg;
  }

  public void setSismsg(Sismsg sismsg) {
    this.sismsg = sismsg;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
