package com.tutorial.springeducationweek1;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
public class RedisTest {

  private static final Logger log = LoggerFactory.getLogger(RedisTest.class);

  @Autowired
  private Jedis jedis;

  @Test
  void testJedis() {
    jedis.set("key2", "hello jedis!!");

    String value = jedis.get("key2");

    log.info("value={}", value);
    
  }
}
