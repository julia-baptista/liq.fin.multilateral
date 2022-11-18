package com.trybe.liqFinaMultilateral.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.trybe.liqFinaMultilateral.initialload.Grupo_SLC0001_LiquidProdt;
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

// import com.trybe.liqFinaMultilateral.model.*;
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
  public StaxEventItemReader<Grupo_SLC0001_LiquidProdt> reader() {
    StaxEventItemReader<Grupo_SLC0001_LiquidProdt> reader =
        new StaxEventItemReader<Grupo_SLC0001_LiquidProdt>();
    reader.setResource(new ClassPathResource("SLC0001-modelo.xml"));
    reader.setFragmentRootElementName("Grupo_SLC0001_LiquidProdt");

    Map<String, String> aliasesMap = new HashMap<String, String>();
    aliasesMap.put("Grupo_SLC0001_LiquidProdt",
        "com.trybe.liqFinaMultilateral.initialload.Grupo_SLC0001_LiquidProdt");
    XStreamMarshaller marshaller = new XStreamMarshaller();
    marshaller.setAliases(aliasesMap);

    reader.setUnmarshaller(marshaller);
    return reader;
  }

  @Bean
  public JdbcBatchItemWriter<Grupo_SLC0001_LiquidProdt> writer() {
    JdbcBatchItemWriter<Grupo_SLC0001_LiquidProdt> writer =
        new JdbcBatchItemWriter<Grupo_SLC0001_LiquidProdt>();
    writer.setDataSource(dataSource);
    writer.setSql(
        "INSERT INTO financeiroDetalhes(identdLinhaBilat, tpDeb_Cred, ISPBIFCredtd, ISPBIFDebtd,"
            + "vlrLanc, CNPJNLiqdantDebtd, nomCliDebtd, CNPJNLiqdantCredtd, nomCliCredtd, tpTranscSLC) VALUES(?,?,?,?,?,?,?,?,?,?)");
    writer.setItemPreparedStatementSetter(new DetalhesPreparedStatementSetter());
    return writer;
  }

  @Bean
  public Step step1() {
    return stepBuilderFactory.get("step1")
        .<Grupo_SLC0001_LiquidProdt, Grupo_SLC0001_LiquidProdt>chunk(100).reader(reader())
        .processor(processor()).writer(writer()).build();
  }

  @Bean
  public Job exportPerosnJob() {
    return jobBuilderFactory.get("importGrupo_SLC0001_LiquidProdt")
        .incrementer(new RunIdIncrementer()).flow(step1()).end().build();
  }
}
