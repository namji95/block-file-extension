package com.flow.blockfileextension.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class GlobalCustomException {

  @ExceptionHandler(CustomException.class)
  protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
    return ErrorResponse.toResponseEntity(e.getErrorCode());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> processValidationException(MethodArgumentNotValidException e) {
    BindingResult bindingResult = e.getBindingResult();

    StringBuilder builder = new StringBuilder();
    if (bindingResult.getFieldError().getField().equals("extensionName")) {
      for (FieldError fieldError : bindingResult.getFieldErrors()) {
        builder
            .append("확장자 이름은 ")
            .append(fieldError.getDefaultMessage())
            .append("\n")
            .append("입력된 값 : ")
            .append(fieldError.getRejectedValue());
      }
    }

    return new ResponseEntity<>(builder.toString(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public ResponseEntity<String> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body("파일 크기가 너무 큽니다. 파일 크기는 최대 10MB까지 허용됩니다.");
  }
}
