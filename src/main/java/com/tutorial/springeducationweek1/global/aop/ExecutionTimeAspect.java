package com.tutorial.springeducationweek1.global.aop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ExecutionTimeAspect {

  @Pointcut("execution(* com.tutorial.springeducationweek1.domain..*(..))")
  private void allServiceMethods() {

  }


  @Around("@annotation(com.tutorial.springeducationweek1.common.annotation.ExecutionTime)")
  public Object annotationExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    LocalDateTime startDateTime = LocalDateTime.now();
    long nanoStart = System.nanoTime();
    log.info(
        "========================================================================================================");
    log.info("시작 실행 시간: {}", startDateTime.format(formatter));

    Object result = proceedingJoinPoint.proceed();

    LocalDateTime endDateTime = LocalDateTime.now();
    long nanoEnd = System.nanoTime();
    long executionNano = nanoEnd - nanoStart;

    log.info("종료 실행 시간: {}", endDateTime.format(formatter));
    log.info("'{}' 메서드 실행 시간: {}ms",
        proceedingJoinPoint.getSignature().toShortString(), executionNano / 1_000_000);
    log.info(
        "========================================================================================================");

    return result;
  }
}
