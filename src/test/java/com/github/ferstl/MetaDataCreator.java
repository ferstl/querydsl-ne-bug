package com.github.ferstl;

import java.io.File;
import java.sql.Connection;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.querydsl.sql.codegen.MetaDataExporter;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class MetaDataCreator {

  @Autowired
  private JdbcOperations jdbcOperations;

  @Test
  public void exportMetadata() {
    MetaDataExporter exporter = new MetaDataExporter();
    exporter.setPackageName("com.github.ferstl");
    exporter.setTargetFolder(new File("src/main/java"));
    this.jdbcOperations.execute((Connection connection) -> {
      exporter.export(connection.getMetaData());
      return null;
    });
  }
}
