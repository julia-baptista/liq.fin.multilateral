package com.trybe.liqFinaMultilateral.initialload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Grupo_SLC0001_Prodt {

  private String CodProdt;

  private List<Grupo_SLC0001_LiquidProdt> Grupo_SLC0001_LiquidProdt = new ArrayList<>();

}
