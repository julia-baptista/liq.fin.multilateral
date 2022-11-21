package com.trybe.liqFinaMultilateral.dtos;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrupoSLC0001LiquidDTO {

  private Integer numSeqCicloLiquid;
  private String dtLiquid;
  private List<GrupoSlc0001ProdtDTO> gruposSlc0001ProdtDTO;

}
