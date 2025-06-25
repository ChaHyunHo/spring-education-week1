package com.tutorial.springeducationweek1.common.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ServiceExceptionCode {
  NOT_FOUNT_DATA("데이터를 찾을 수 없습니다."),
  NOT_FOUNT_USER("사용자를 찾을 수 없습니다.");
  final String message;
}
