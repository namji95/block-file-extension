package com.flow.blockfileextension.controller;

import com.flow.blockfileextension.common.CommonResponse;
import com.flow.blockfileextension.dto.ExtensionRequest;
import com.flow.blockfileextension.dto.ExtensionResponse;
import com.flow.blockfileextension.service.FixedExtensionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/extension")
public class FixedExtensionController {

  private final FixedExtensionService fileExtensionService;

  @PostMapping()
  public void createFixedExtension(@RequestBody @Valid ExtensionRequest request) {
    fileExtensionService.createFixedExtension(request);
  }

  @GetMapping("/all")
  public ResponseEntity<CommonResponse<List<ExtensionResponse>>> getAllFixedExtension() {
    List<ExtensionResponse> responses = fileExtensionService.getAllFixedExtension();

    return ResponseEntity.status(HttpStatus.OK.value()).body(
        CommonResponse.<List<ExtensionResponse>>builder()
            .msg("success")
            .data(responses)
            .build());
  }

  @DeleteMapping("/delete")
  public void deleteFixedExtension(@RequestBody @Valid ExtensionRequest request) {
    fileExtensionService.deleteFixedExtension(request);
  }

  /*
   * todo: 고정 확장자 추가 기능 구현 -- 시간 될 시
   *  기능 구현 시 최대 10개로 제한 grid 이용
   * */
}
