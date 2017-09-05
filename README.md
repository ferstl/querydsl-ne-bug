# querydsl-ne-bug

*- Reproduce QueryDsl Bug https://github.com/querydsl/querydsl/issues/2197*

- The bug is reproduced in the class `com.github.ferstl.QueryDslNeBugTest`
  - The test should select all entries from `table_a` which do not have `cat-1` assigned in `table_b`
- The test schema is `src/test/resources/schema.sql`
- The test data is in `src/test/resources/data.sql`
- How to Run
  ```
  git clone git@github.com:ferstl/querydsl-ne-bug.git
  cd querydsl-ne-bug
  mvn test
  ```
