package com.tutorial.springeducationweek1.global.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfig {

  // application.properties에서 redis.host 값을 주입받음
  @Value("${spring.data.redis.host}")
  private String redisHost;

  // application.properties에서 redis.port 값을 주입받음
  @Value("${spring.data.redis.port}")
  private int redisPort;

  // application.properties에서 redis.password 값을 주입받음 (비밀번호가 없으면 null 또는 빈 문자열)
  @Value("${spring.data.redis.password:}") // 기본값을 빈 문자열로 설정하여 비밀번호가 없을 때 오류 방지
  private String redisPassword;

  @Bean // 스프링 컨테이너에 Jedis 인스턴스를 빈으로 등록
  public Jedis jedis() {
    Jedis jedis = new Jedis(redisHost, redisPort);

    if (redisPassword != null && !redisPassword.isEmpty()) {
      jedis.auth(redisPassword); // 비밀번호가 있다면 인증
    }

    return jedis;
  }


}
