package com.flow.blockfileextension.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fixed_extension")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FixedExtension {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "extension_name")
  private String extensionName;

  public FixedExtension(String extensionName) {
    this.extensionName = extensionName;
  }
}
