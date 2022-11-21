package com.trybe.liqFinaMultilateral.writer;

import com.trybe.liqFinaMultilateral.model.Doc;
import com.trybe.liqFinaMultilateral.service.XmlService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemXmlWriter implements ItemWriter<Doc> {

  @Autowired
  private XmlService xmlService;

  @Override
  public void write(List<? extends Doc> list) throws Exception {
    list.stream().forEach(doc -> xmlService.loadXml(doc));
  }

}
