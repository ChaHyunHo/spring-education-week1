package com.tutorial.springeducationweek1.global.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

  // 서비스 계층 포인트컷
  @Pointcut("execution(* com.tutorial.springeducationweek1.domain..*Service.*(..))")
  private void allServiceMethods() {
  }

  @Around("allServiceMethods()")
  public Object logMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    String methodName = joinPoint.getSignature().toShortString();
    long start = System.currentTimeMillis();

    try {
      Object result = joinPoint.proceed(); // 실제 메서드 실행
      long end = System.currentTimeMillis();
      log.info("[메소드명 : {}] 실행 시간: {} ms", methodName, end - start);
      return result;
    } catch (Throwable throwable) {
      log.error("예외 발생: [{}] threw exception: {}", methodName, throwable.getMessage());
      throw throwable;
    }
  }

  @AfterThrowing(pointcut = "allServiceMethods()", throwing = "serviceException")
  public void logServiceException(
      com.tutorial.springeducationweek1.common.exception.ServiceException serviceException) {
    log.error("서비스 계층 예외 발생: Code = [{}], Message = [{}]",
        serviceException.getCode(), serviceException.getMessage());

  }
}
