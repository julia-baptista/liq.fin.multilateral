package com.trybe.liqFinaMultilateral.dtos;


import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrupoSlc0001LiquidProdtDTO {

  private String identdLinhaBilat;
  private String tpDebCred;
  private Long ispbIfCredtd;
  private Long ispbIfDebtd;
  private BigDecimal vlrLanc;
  private String cnpjLiqdantDebtd;
  private String nomCliDebtd;
  private String cnpjNLiqdantCredtd;
  private String nomCliCredtd;
  private String tpTranscSLC;

}
