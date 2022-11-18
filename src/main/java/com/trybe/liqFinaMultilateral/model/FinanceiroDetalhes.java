package com.trybe.liqFinaMultilateral.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "financeiroDetalhes")
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
