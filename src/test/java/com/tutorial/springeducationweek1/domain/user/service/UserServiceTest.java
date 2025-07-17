package com.tutorial.springeducationweek1.domain.user.service;

import com.tutorial.springeducationweek1.domain.user.entity.User;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class UserServiceTest {

  private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

  @Autowired
  private UserService userService;

  @Autowired
  private EntityManager entityManager;

  @Test
  void saveAllUser() {

    // given
    List<User> users = getUsers(2000);

    // when
    userService.saveAllUser(users);

    // then
    User user = entityManager.createQuery(
        "select u from User u order by u.id desc", User.class
    ).setMaxResults(1).getSingleResult();

    log.info("\n latest user id = {}",
        String.format("\n %s \n %s \n %s", user.getId(), user.getName(), user.getEmail()));
  }

  private List<User> getUsers(int count) {
    List<User> users = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      users.add(User.builder()
          .name("test" + i)
          .email("test" + i + "@example.com")
          .passwordHash("test" + i)
          .build());
    }
    log.info("user size= {}", users.size());
    return users;
  }
}