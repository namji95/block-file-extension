package com.flow.blockfileextension.controller;

import com.flow.blockfileextension.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/file")
public class FileController {

  private final FileService fileService;

  @PostMapping()
  public String saveFolder(@RequestParam("file")MultipartFile file) throws IOException {
    return fileService.saveFile(file);
  }

}
