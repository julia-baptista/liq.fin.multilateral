package com.trybe.liqFinaMultilateral.dtos;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrupoSlc0001ProdtDTO {

  private String codProdt;
  private List<GrupoSlc0001LiquidProdtDTO> gruposSlc0001LiquidProdt;

}
