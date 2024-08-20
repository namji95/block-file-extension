package com.flow.blockfileextension.test;

import com.flow.blockfileextension.entity.CustomExtension;
import com.flow.blockfileextension.repository.CustomExtensionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@SpringBootTest
public class TestCode {

  @Autowired
  private CustomExtensionRepository customExtensionRepository;

  @Test
  public void saveMultipleCustomExtensions() {
    // 200개의 더미 데이터 생성 및 저장
    for (int i = 0; i < 200; i++) {
      // 랜덤 확장자 이름 생성
      String randomExtensionName = generateRandomExtensionName();

      // CustomExtension 엔티티 생성
      CustomExtension customExtension = new CustomExtension();
      customExtension.setCustomExtensionName(randomExtensionName);

      // 데이터베이스에 저장
      customExtensionRepository.save(customExtension);
    }
  }

  // 랜덤 확장자 이름 생성 메서드
  private String generateRandomExtensionName() {
    String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder extensionName = new StringBuilder();
    Random random = new Random();
    int length = random.nextInt(20) + 1; // 1자 ~ 20자 사이의 길이

    for (int i = 0; i < length; i++) {
      extensionName.append(characters.charAt(random.nextInt(characters.length())));
    }

    return extensionName.toString();
  }
}
