package com.tutorial.springeducationweek1.global.aop;

import com.tutorial.springeducationweek1.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

  @Pointcut("execution(* com.tutorial.springeducationweek1.domain..*(..))")
  private void allServiceMethods() {

  }

  @Before("execution(* com.tutorial.springeducationweek1.domain..controller..*(..))")
  public void logBeforeApiExecution() {
    log.info("[API-execution] API 메서드 실행 전 로그");
  }

  @Before("allServiceMethods()")
  public void logBeforeWithin() {
    log.info("[API-within] domin 패키지 내부 메서드 실행 전 로그");
  }

  @Before("@annotation(com.tutorial.springeducationweek1.common.annotation.Loggable)")
  public void logBeforeAnnotation() {
    log.info("[@annotation] @Loggable 어노테이션 적용된 메서드 실행 전 로그");
  }

  @Before("execution(* com.tutorial.springeducationweek1.domain..*(..))")
  public void logMethodDetails(JoinPoint joinPoint) {
    log.info("[joinPoint 활용] 실행된 메서드 이름: {}", joinPoint.getSignature().getName());
    Object[] args = joinPoint.getArgs();

    if (args.length > 0) {
      log.info("[JoinPoint 활용 전달된 파라미터: {}", args);
    }
  }

  @AfterThrowing(pointcut = "allServiceMethods()", throwing = "serviceException")
  public void logServiceException(ServiceException serviceException) {
    log.error("Service Layer Exception: Code = [{}], Message = [{}]",
        serviceException.getCode(), serviceException.getMessage());

  }
}
