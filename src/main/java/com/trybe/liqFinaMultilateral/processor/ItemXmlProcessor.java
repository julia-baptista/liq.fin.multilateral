package com.trybe.liqFinaMultilateral.processor;

import com.trybe.liqFinaMultilateral.model.Doc;
import org.springframework.batch.item.ItemProcessor;

public class ItemXmlProcessor implements ItemProcessor<Doc, Doc> {

  @Override
  public Doc process(Doc doc) throws Exception {
    return doc;
  }
}
