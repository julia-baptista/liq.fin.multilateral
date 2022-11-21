package com.trybe.liqFinaMultilateral.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SISMSG")
@Entity(name = "TB_SISMSG")
public class Sismsg {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "slc0001_id")
  private Slc0001 slc0001;

  @OneToOne(mappedBy = "sismsg", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Doc doc;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @XmlElement(name = "SLC0001")
  public Slc0001 getSlc0001() {
    return slc0001;
  }

  public void setSlc0001(Slc0001 slc0001) {
    this.slc0001 = slc0001;
  }

  public Doc getDoc() {
    return doc;
  }

  public void setDoc(Doc doc) {
    this.doc = doc;
  }
}
