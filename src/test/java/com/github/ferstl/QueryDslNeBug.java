package com.github.ferstl;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.querydsl.sql.H2Templates;
import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.SQLQueryFactory;

import static com.github.ferstl.QTableA.tableA;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class QueryDslNeBug {

  @Autowired
  private JdbcOperations jdbcOperations;

  @Autowired
  private DataSource dataSource;

  @Test
  public void test() throws SQLException {
    H2Templates h2Templates = new H2Templates();
    new com.querydsl.sql.Configuration(h2Templates);
    SQLQuery<Object> query = new SQLQuery<>(this.dataSource.getConnection(), h2Templates);

    SQLQueryFactory queryFactory = new SQLQueryFactory(new com.querydsl.sql.Configuration(h2Templates), this.dataSource);
    System.out.println(queryFactory.query().select(tableA.description).from(tableA).fetch());

  }

}
