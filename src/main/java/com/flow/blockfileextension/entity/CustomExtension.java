package com.flow.blockfileextension.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomExtension {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String customExtensionName;

  public CustomExtension(String extensionName) {
    this.customExtensionName = extensionName;
  }
}
