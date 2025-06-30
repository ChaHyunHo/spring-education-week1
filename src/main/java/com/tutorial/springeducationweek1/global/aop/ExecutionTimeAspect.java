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

//  @Around("allServiceMethods()")
//  public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
//
//    // 1. 메서드 실행 전: 시작 시간 기록
//    long startTime = System.currentTimeMillis();
//
//    // 1. 메서드 실행 전: 시작 시간 기록
//    LocalDateTime startDateTime = LocalDateTime.now();
//    long nanoStart = System.nanoTime();
//    log.info(
//        "========================================================================================================");
//    log.info("시작 실행 시간: {}", startDateTime.format(formatter));
//
//    // 2. 실제 타겟 메서드 실행
//    Object result = proceedingJoinPoint.proceed();
//
//    // 3. 메서드 실행 후: 종료 시간 및 실행 시간 계산
//    LocalDateTime endDateTime = LocalDateTime.now();
//    long nanoEnd = System.nanoTime();
//    long executionNano = nanoEnd - nanoStart;
//
//    log.info("종료 실행 시간: {}", endDateTime.format(formatter));
//    // 3. 메서드 실행 후: 종료 시간 기록 및 실행 시간 계산/로깅
//    long endTime = System.currentTimeMillis();
//    long executionTime = endTime - startTime;
//    log.info("'{}' 메서드 실행 시간: {}ms", proceedingJoinPoint.getSignature().toShortString(),
//        executionTime);
//    log.info(
//        "========================================================================================================");
//
//    // 4. 원래 메서드의 실행 결과를 반환
//    return result;
//
//  }

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
