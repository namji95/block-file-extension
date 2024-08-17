package com.flow.blockfileextension.controller;

import com.flow.blockfileextension.dto.ExtensionRequest;
import com.flow.blockfileextension.dto.ExtensionResponse;
import com.flow.blockfileextension.service.CustomExtensionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/custom-extension")
public class CustomExtensionController {

  private final CustomExtensionService customExtensionService;

  @PostMapping()
  public ExtensionResponse createCustomExtension(@RequestBody @Valid ExtensionRequest request) {
    return customExtensionService.createCustomExtension(request);
  }

  @GetMapping("/all")
  public List<ExtensionResponse> getAllCustomExtensions() {
    return customExtensionService.getAllCustomExtension();
  }

  @DeleteMapping("/delete")
  public ExtensionResponse deleteCustomExtension(@RequestBody @Valid ExtensionRequest request) {
    return customExtensionService.deleteCustomExtension(request);
  }
}
