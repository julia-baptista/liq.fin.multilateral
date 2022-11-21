package com.trybe.liqFinaMultilateral.dtos;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BcmsgDTO {

  private Double nuOp;
  private Integer identdEmissor;
  private Integer identdDestinatario;
  private GrupoSeqDTO grupoSeqDTO;
  private String domSist;

}
