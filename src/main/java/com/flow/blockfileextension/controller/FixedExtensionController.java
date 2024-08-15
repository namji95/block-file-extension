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
}
