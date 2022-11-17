package com.trybe.liqFinaMultilateral.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FinanceiroDetalhes {

  @Id
  private String identdLinhaBilat;
  private String tpDeb_Cred;
  private Long ISPBIFCredtd;
  private Long ISPBIFDebtd;
  private Double vlrLanc;
  private Long CNPJNLiqdantDebtd;
  private String nomCliDebtd;
  private Long CNPJNLiqdantCredtd;
  private String nomCliCredtd;
  private String tpTranscSLC;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "grupo_id")
  @JsonIgnore
  private FinanceiroGrupo grupo;
}
