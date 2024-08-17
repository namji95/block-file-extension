package com.flow.blockfileextension.controller;

import com.flow.blockfileextension.common.CommonResponse;
import com.flow.blockfileextension.dto.ExtensionRequest;
import com.flow.blockfileextension.dto.ExtensionResponse;
import com.flow.blockfileextension.service.CustomExtensionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/custom-extension")
public class CustomExtensionController {

  private final CustomExtensionService customExtensionService;

  @PostMapping()
  public void createCustomExtension(@RequestBody @Valid ExtensionRequest request) {
    customExtensionService.createCustomExtension(request);
  }

  @GetMapping("/all")
  public ResponseEntity<CommonResponse<List<ExtensionResponse>>> getAllCustomExtensions() {
    List<ExtensionResponse> responses = customExtensionService.getAllCustomExtension();

    return ResponseEntity.status(HttpStatus.OK.value()).body(
        CommonResponse.<List<ExtensionResponse>>builder()
            .msg("success")
            .data(responses)
            .build());
  }

  @DeleteMapping("/delete")
  public void deleteCustomExtension(@RequestBody @Valid ExtensionRequest request) {
    customExtensionService.deleteCustomExtension(request);
  }
}
