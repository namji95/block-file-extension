package com.flow.blockfileextension.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "files")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class File {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String originalFilename;
  private String name;
  private String type;

  public File(String originalFilename, String name, String type) {
    this.originalFilename = originalFilename;
    this.name = name;
    this.type = type;
  }
}
