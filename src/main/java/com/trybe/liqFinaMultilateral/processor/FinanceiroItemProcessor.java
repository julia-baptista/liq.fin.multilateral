package com.trybe.liqFinaMultilateral.processor;

import org.springframework.batch.item.ItemProcessor;

import com.trybe.liqFinaMultilateral.model.FinanceiroDetalhes;

public class FinanceiroItemProcessor
    implements ItemProcessor<FinanceiroDetalhes, FinanceiroDetalhes> {

  @Override
  public FinanceiroDetalhes process(FinanceiroDetalhes financeiroDetalhes) throws Exception {
    return financeiroDetalhes;
  }
}
