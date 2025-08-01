package com.tutorial.springeducationweek1.domain.category.service;


import com.tutorial.springeducationweek1.domain.category.entity.Category;
import com.tutorial.springeducationweek1.domain.category.repository.CategoryJdbcRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CategoryJdbcService {

  private final DataSource dataSource;
  private final CategoryJdbcRepository categoryJdbcRepository;

  public void updateCategory(Long categoryId, String name) throws SQLException {
    Connection connection = dataSource.getConnection();

    try {
      connection.setAutoCommit(false);

      Category category = categoryJdbcRepository.findById(connection, categoryId);
      if (Objects.nonNull(category)) {
        categoryJdbcRepository.update(connection, categoryId, name);
      }

      connection.commit();

    } catch (Exception error) {
      connection.rollback();
      throw new IllegalStateException(error);

    } finally {
      release(connection);
    }

  }

  private void release(Connection connection) {
    if (connection != null) {
      try {
        connection.setAutoCommit(true);
        connection.close();
      } catch (Exception error) {
        log.info("release : ", error);
      }
    }
  }

}
