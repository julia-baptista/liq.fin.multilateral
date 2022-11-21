package com.trybe.liqFinaMultilateral.config;

import com.trybe.liqFinaMultilateral.model.Doc;
import com.trybe.liqFinaMultilateral.processor.ItemXmlProcessor;
import com.trybe.liqFinaMultilateral.writer.ItemXmlWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.sql.DataSource;

// https://keyholesoftware.com/2021/10/05/using-jaxb-and-staxeventitemreader-to-read-xml-data/
// https://json2csharp.com/code-converters/xml-to-java
@Configuration
@EnableBatchProcessing
public class BatchConfig {

  public static final String JOB_NAME = "LiqFinaMultilateral-Processing-Job";

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Autowired
  private DataSource dataSource;

  @Bean
  @StepScope
  public ItemXmlProcessor itemProcessor() {
    return new ItemXmlProcessor();
  }

  @Bean
  @StepScope
  public StaxEventItemReader<Doc> itemReader() throws Exception {
    Resource resource = new ClassPathResource("SLC0001-modelo.xml");
    StaxEventItemReader<Doc> xmlFileReader = new StaxEventItemReader<Doc>();
    xmlFileReader.setResource(resource);
    xmlFileReader.setFragmentRootElementName("DOC");

    Jaxb2Marshaller xmlMarshaller = new Jaxb2Marshaller();
    xmlMarshaller.setClassesToBeBound(Doc.class);
    xmlMarshaller.afterPropertiesSet();
    xmlFileReader.setUnmarshaller(xmlMarshaller);
    return xmlFileReader;
  }

  @Bean
  @StepScope
  public ItemXmlWriter itemWriter() {
    return new ItemXmlWriter();
  }

  @Bean
  public Step processXmlFile() throws Exception {
    return stepBuilderFactory.get("processXmlFile").<Doc, Doc>chunk(100).reader(itemReader())
        .processor(itemProcessor()).writer(itemWriter()).build();
  }

  @Bean
  public Job processXmlFileJob() throws Exception {
    return jobBuilderFactory.get(JOB_NAME).incrementer(new RunIdIncrementer())
        .flow(processXmlFile()).end().build();
  }
}
