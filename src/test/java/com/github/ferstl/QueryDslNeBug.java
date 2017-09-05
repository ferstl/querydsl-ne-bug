package com.github.ferstl;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.querydsl.sql.H2Templates;
import com.querydsl.sql.SQLQueryFactory;

import static com.github.ferstl.QTableA.tableA;
import static com.github.ferstl.QTableB.tableB;
import static com.querydsl.sql.SQLExpressions.select;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class QueryDslNeBug {

  @Autowired
  private DataSource dataSource;
  private SQLQueryFactory queryFactory;

  @Before
  public void before() {
    H2Templates h2Templates = new H2Templates();
    this.queryFactory = new SQLQueryFactory(new com.querydsl.sql.Configuration(h2Templates), this.dataSource);

  }

  @Test
  public void test() throws SQLException {
    long result = this.queryFactory.query()
        .select(tableA.id.count())
        .from(tableA)
        .where(
            select(tableB.category)
                .from(tableB)
                .where(tableB.aRef.eq(tableA.id))
                .ne("cat-1"))
        .fetchOne();

    assertEquals(2L, result);
  }

}
