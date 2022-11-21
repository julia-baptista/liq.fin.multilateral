package com.trybe.liqFinaMultilateral.dtos;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocDTO {

  private BcmsgDTO bcmsgDTO;
  private SismsgDTO sismsgDTO;

}
