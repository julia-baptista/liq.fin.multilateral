package com.trybe.liqFinaMultilateral.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "Grupo_SLC0001_Prodt")
@Entity(name = "TB_Grupo_SLC0001_Prodt")
public class GrupoSlc0001Prodt {

  @Id
  @Column(name = "COD_PRODT")
  private String codProdt;

  @OneToMany(mappedBy = "grupoSlc0001Prodt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<GrupoSlc0001LiquidProdt> grupoSlc0001LiquidProdt;

  @ManyToOne
  @JoinColumn(name = "numSeqCicloLiquid")
  private GrupoSLC0001Liquid grupoSLC0001Liquid;

  @XmlElement(name = "Grupo_SLC0001_LiquidProdt")
  public List<GrupoSlc0001LiquidProdt> getGrupoSlc0001LiquidProdt() {
    if (grupoSlc0001LiquidProdt == null) {
      grupoSlc0001LiquidProdt = new ArrayList<GrupoSlc0001LiquidProdt>();
    }
    return grupoSlc0001LiquidProdt;
  }

  @XmlElement(name = "CodProdt")
  public String getCodProdt() {
    return codProdt;
  }

  public void setGrupoSlc0001LiquidProdt(List<GrupoSlc0001LiquidProdt> grupoSlc0001LiquidProdt) {
    this.grupoSlc0001LiquidProdt = grupoSlc0001LiquidProdt;
  }

  public void setCodProdt(String codProdt) {
    this.codProdt = codProdt;
  }

  public GrupoSLC0001Liquid getGrupoSLC0001Liquid() {
    return grupoSLC0001Liquid;
  }

  public void setGrupoSLC0001Liquid(GrupoSLC0001Liquid grupoSLC0001Liquid) {
    this.grupoSLC0001Liquid = grupoSLC0001Liquid;
  }
}
