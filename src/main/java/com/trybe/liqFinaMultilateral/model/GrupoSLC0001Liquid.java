package com.trybe.liqFinaMultilateral.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Grupo_SLC0001_Liquid")
@Entity(name = "TB_Grupo_SLC0001_Liquid")
public class GrupoSLC0001Liquid {

  @Id
  @Column(name = "NumSeqCicloLiquid")
  private Integer numSeqCicloLiquid;

  @Column(name = "DtLiquid")
  private String dtLiquid;

  @OneToMany(mappedBy = "grupoSLC0001Liquid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<GrupoSlc0001Prodt> grupoSlc0001Prodt;

  @OneToOne(mappedBy = "grupoSlc0001Liquid", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Slc0001 slc0001;

  @XmlElement(name = "DtLiquid")
  public String getDtLiquid() {
    return dtLiquid;
  }

  @XmlElement(name = "NumSeqCicloLiquid")
  public Integer getNumSeqCicloLiquid() {
    return numSeqCicloLiquid;
  }

  @XmlElement(name = "Grupo_SLC0001_Prodt")
  public List<GrupoSlc0001Prodt> getGrupoSlc0001Prodt() {
    if (grupoSlc0001Prodt == null) {
      grupoSlc0001Prodt = new ArrayList<GrupoSlc0001Prodt>();
    }
    return grupoSlc0001Prodt;
  }

  public void setDtLiquid(String dtLiquid) {
    this.dtLiquid = dtLiquid;
  }

  public void setNumSeqCicloLiquid(Integer numSeqCicloLiquid) {
    this.numSeqCicloLiquid = numSeqCicloLiquid;
  }

  public void setGrupoSlc0001Prodt(List<GrupoSlc0001Prodt> grupoSlc0001Prodt) {
    this.grupoSlc0001Prodt = grupoSlc0001Prodt;
  }

  public Slc0001 getSlc0001() {
    return slc0001;
  }

  public void setSlc0001(Slc0001 slc0001) {
    this.slc0001 = slc0001;
  }
}
