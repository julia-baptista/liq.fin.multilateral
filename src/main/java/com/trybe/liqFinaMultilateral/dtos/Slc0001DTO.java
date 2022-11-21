package com.trybe.liqFinaMultilateral.dtos;

import com.trybe.liqFinaMultilateral.model.Sismsg;
import lombok.*;

import java.util.Date;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Slc0001DTO {

  private String codMsg;
  private String numCtrlSLC;
  private Integer ispbif;
  private String tpInf;
  private GrupoSLC0001LiquidDTO grupoSlc0001LiquidDTO;
  private Date dtHrSLC;
  private String dtMovto;

}
