package com.tutorial.springeducationweek1;


import java.util.List;
import java.util.Map;
import java.util.Set;
import org.flywaydb.core.internal.util.JsonUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
public class RedisDataTest {

  private static final Logger log = LoggerFactory.getLogger(RedisDataTest.class);

  @Autowired
  private Jedis jedis;

  @Test
  void redisStringExample() {
    // api : /api/users/34
    jedis.set("users:34:session", "{\"id\" : 34, \"name\" : \"홍길동\"}");

    String response = jedis.get("users:34:session");

    log.info("/api/users/34 요청 테스트 : {}", response);

    Long ttl = jedis.ttl("users:34:session");
    log.info("/api/users/34 , ttl : {}", ttl);

    jedis.set("article:101:views", "0");

    jedis.incr("article:101:views");
    jedis.incrBy("article:101:views", 100);

    jedis.decr("article:101:views");

    log.info("article:101:views : {}", jedis.get("article:101:views"));

  }

  @Test
  void redisListExample() {

    jedis.lpush("queue:tasks", "task1", "task2", "task3", "task4", "task5");

    Long queueSize = jedis.llen("queue:tasks");
    log.info("queue:tasks : {}", queueSize);

    String L_task = jedis.lpop("queue:tasks");
    log.info("l_task : {}", L_task);

    String R_task = jedis.rpop("queue:tasks");
    log.info("r_task : {}", R_task);

  }

  @Test
  void redisSetExample() {
    jedis.del("set1");
    jedis.del("set2");

    jedis.sadd("set1", "task1", "task2", "task4");
    jedis.sadd("set2", "task1", "task3", "task4");

    Set<String> sinterSet = jedis.sinter("set1", "set2");// 교집합
    log.info("sinterSet : {}", JsonUtils.toJson(sinterSet));

    Set<String> sunterSet = jedis.sunion("set1", "set2"); // 합집합
    log.info("sunterSet : {}", JsonUtils.toJson(sunterSet));
  }

  @Test
  void redisHashExample() {
    jedis.hset("users:1234", "name", "John doe");
    jedis.hset("users:1234", "email", "john.doe@example.com");
    jedis.hset("users:1234", "age", "30");
    jedis.hset("users:1234", "city", "New york");

    String name = jedis.hget("users:1234", "name");

    Map<String, String> hget = jedis.hgetAll("users:1234");

    log.info("get :\n{}", JsonUtils.toJson(hget));

  }

  @Test
  void redisSortedSetExample() {

    jedis.del("users:123:friendly");

    jedis.zadd("users:123:friendly", 100, "friend1");
    jedis.zadd("users:123:friendly", 200, "friend2");
    jedis.zadd("users:123:friendly", 300, "friend3");
    jedis.zadd("users:123:friendly", 400, "friend4");

    List<String> friends1 = jedis.zrange("users:123:friendly", 0, 4);
    List<String> friends2 = jedis.zrevrange("users:123:friendly", 0, 4);

    log.info("sorted friends :\n{} \n{}", JsonUtils.toJson(friends1), JsonUtils.toJson(friends2));

    Double score = jedis.zscore("users:123:friendly", "friend1");
    log.info("score : {}", score);

    jedis.zincrby("users:123:friendly", 120, "friend1");

    List<String> friends3 = jedis.zrange("users:123:friendly", 0, 4);
    List<String> friends4 = jedis.zrevrange("users:123:friendly", 0, 4);

    log.info("sorted friends :\n{} \n{}", JsonUtils.toJson(friends3), JsonUtils.toJson(friends4));
  }
}
