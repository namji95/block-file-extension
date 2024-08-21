package com.flow.blockfileextension.dto;

import lombok.Getter;

@Getter
public class FileResponse {

  private String fileName;

  public FileResponse(String originalFilename) {
    this.fileName = originalFilename;
  }
}
