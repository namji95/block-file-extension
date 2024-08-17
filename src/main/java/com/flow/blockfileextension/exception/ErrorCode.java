package com.flow.blockfileextension.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  SUCCESS(HttpStatus.OK, "OK"),

  RANGE_LIMIT(HttpStatus.BAD_REQUEST, "확장자를 더 이상 추가할 수 없습니다. 확장자는 200개까지 저장할 수 있습니다."),
  NOT_FOUND_EXTENSION(HttpStatus.NOT_FOUND, "확장자가 존재하지 않습니다.");

  private final HttpStatus httpStatus;
  private final String message;
}
