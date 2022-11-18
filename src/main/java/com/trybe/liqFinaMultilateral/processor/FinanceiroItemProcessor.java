package com.trybe.liqFinaMultilateral.processor;

import org.springframework.batch.item.ItemProcessor;

import com.trybe.liqFinaMultilateral.initialload.Grupo_SLC0001_LiquidProdt;

public class FinanceiroItemProcessor
    implements ItemProcessor<Grupo_SLC0001_LiquidProdt, Grupo_SLC0001_LiquidProdt> {

  @Override
  public Grupo_SLC0001_LiquidProdt process(Grupo_SLC0001_LiquidProdt grupo_SLC0001_LiquidProdt)
      throws Exception {
    return grupo_SLC0001_LiquidProdt;
  }
}
