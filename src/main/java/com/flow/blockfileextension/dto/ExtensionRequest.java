package com.flow.blockfileextension.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ExtensionRequest {

  @NotBlank(message = "확장자 선택 또는 작성해야 합니다.")
  @Pattern(regexp = "^[a-zA-Z]*$", message = "영어만 작성할 수 있습니다.")
  @Size(min = 1, max = 20, message = "1자 ~ 20자내로 작성해주시기 바랍니다.")
  private String extensionName;

  private Boolean bool;
}
