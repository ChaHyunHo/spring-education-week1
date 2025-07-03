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
  INSUFFICIENT_STOCK("재고가 부족합니다."),
  NOT_FOUNT_USER("사용자를 찾을 수 없습니다."),
  NOT_FOUNT_CATEGORY_PARENT("상위 카테고리가 존재하지 않습니다."),
  CANNOT_CANCEL("취소할 수 없습니다."),
  INVALID_OPERATION("환불을 진행할 수 없습니다.");

  final String message;
}
