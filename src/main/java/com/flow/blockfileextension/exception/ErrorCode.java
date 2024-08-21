package com.flow.blockfileextension.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  SUCCESS(HttpStatus.OK, "OK"),

  RANGE_LIMIT(HttpStatus.BAD_REQUEST, "확장자를 더 이상 추가할 수 없습니다. 확장자는 200개까지 저장할 수 있습니다."),
  NOT_FOUND_EXTENSION(HttpStatus.NOT_FOUND, "확장자가 존재하지 않습니다."),
  DUPLICATE_EXTENSION(HttpStatus.BAD_REQUEST, "해당 확장자는 이미 차단된 확장자입니다."),
  EXTENSION_NOT_EXIST(HttpStatus.BAD_REQUEST, "확장자가 존재하지 않는 파일입니다."),
  BLOCKED_EXTENSION(HttpStatus.BAD_REQUEST, "차단된 확장자 입니다. 다른 파일을 업로드 해주세요."),
  FILE_NOT_EXIST(HttpStatus.BAD_REQUEST, "파일을 올리지 않고 요청하셨습니다. 파일을 업로드 해주세요."),
  EXTENSION_NAME_FORM(HttpStatus.BAD_REQUEST, "영문 확장자가 아닌 확장자는 접근할 수 없습니다. (ex. 공백, 숫자, 한글)");

  private final HttpStatus httpStatus;
  private final String message;
}
