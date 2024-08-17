package com.flow.blockfileextension.controller;

import com.flow.blockfileextension.dto.ExtensionRequest;
import com.flow.blockfileextension.dto.ExtensionResponse;
import com.flow.blockfileextension.service.FixedExtensionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/extension")
public class FixedExtensionController {

  private final FixedExtensionService fileExtensionService;

  @PostMapping()
  public ExtensionResponse createFixedExtension(@RequestBody @Valid ExtensionRequest request) {
    return fileExtensionService.createFixedExtension(request);
  }

  @GetMapping("/all")
  public List<ExtensionResponse> getAllFixedExtension() {
    return fileExtensionService.getAllFixedExtension();
  }

  @DeleteMapping("/delete")
  public ExtensionResponse deleteFixedExtension(@RequestBody @Valid ExtensionRequest request) {
    return fileExtensionService.deleteFixedExtension(request);
  }

  /*
   * todo: 조회된 고정 확장자
   *  view 체크 박스 체크 표시
   * todo: 고정 확장자 추가 기능 구현 -- 시간 될 시
   *  기능 구현 시 최대 10개로 제한 grid 이용
   * */
}
