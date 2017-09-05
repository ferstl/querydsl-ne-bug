package com.github.ferstl;

import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = QueryDslNeBug.TestConfiguration.class)
public class QueryDslNeBug {

  @Autowired
  private DataSource dataSource;

  @Test
  public void test() {
    System.out.println(dataSource);
  }

  @Configuration
  static class TestConfiguration {

    @Bean
    public DataSource dataSource() {
      return new EmbeddedDatabaseBuilder()
          .setType(H2)
          .addDefaultScripts()
          .build();
    }
  }

}
