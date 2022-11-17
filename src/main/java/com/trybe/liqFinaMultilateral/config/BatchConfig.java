package com.trybe.liqFinaMultilateral.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.trybe.liqFinaMultilateral.model.*;
import com.trybe.liqFinaMultilateral.processor.FinanceiroItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Autowired
  private DataSource dataSource;

  @Bean
  public FinanceiroItemProcessor processor() {
    return new FinanceiroItemProcessor();
  }

  @Bean
  public StaxEventItemReader<FinanceiroDetalhes> reader() {
    StaxEventItemReader<FinanceiroDetalhes> reader = new StaxEventItemReader<FinanceiroDetalhes>();
    reader.setResource(new ClassPathResource("persons.xml"));
    reader.setFragmentRootElementName("person");

    Map<String, String> aliasesMap = new HashMap<String, String>();
    aliasesMap.put("financeiroDetalhes", "com.trybe.liqFinaMultilateral.model.FinanceiroDetalhes");
    XStreamMarshaller marshaller = new XStreamMarshaller();
    marshaller.setAliases(aliasesMap);

    reader.setUnmarshaller(marshaller);
    return reader;
  }

  @Bean
  public JdbcBatchItemWriter<FinanceiroDetalhes> writer() {
    JdbcBatchItemWriter<FinanceiroDetalhes> writer = new JdbcBatchItemWriter<FinanceiroDetalhes>();
    writer.setDataSource(dataSource);
    writer.setSql(
        "INSERT INTO financeiroDetalhes(identdLinhaBilat, tpDeb_Cred, ISPBIFCredtd, ISPBIFDebtd,"
            + "vlrLanc, CNPJNLiqdantDebtd, nomCliDebtd, CNPJNLiqdantCredtd, nomCliCredtd, tpTranscSLC) VALUES(?,?,?,?,?,?,?,?,?,?)");
    writer.setItemPreparedStatementSetter(new DetalhesPreparedStatementSetter());
    return writer;
  }

  @Bean
  public Step step1() {
    return stepBuilderFactory.get("step1").<FinanceiroDetalhes, FinanceiroDetalhes>chunk(100)
        .reader(reader()).processor(processor()).writer(writer()).build();
  }

  @Bean
  public Job exportPerosnJob() {
    return jobBuilderFactory.get("importPersonJob").incrementer(new RunIdIncrementer())
        .flow(step1()).end().build();
  }
}
