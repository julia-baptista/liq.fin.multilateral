package com.trybe.liqFinaMultilateral.initialload;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Grupo_SLC0001_LiquidProdt {

  private String IdentdLinhaBilat;
  private String TpDeb_Cred;
  private Long ISPBIFCredtd;
  private Long ISPBIFDebtd;
  private Double VlrLanc;
  private Long CNPJNLiqdantDebtd;
  private String NomCliDebtd;
  private String CNPJNLiqdantCredtd;
  private String NomCliCredtd;
  private String TpTranscSLC;

}
