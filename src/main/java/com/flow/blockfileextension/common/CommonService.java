package com.flow.blockfileextension.common;

import com.flow.blockfileextension.entity.CustomExtension;
import com.flow.blockfileextension.entity.FixedExtension;
import com.flow.blockfileextension.repository.CustomExtensionRepository;
import com.flow.blockfileextension.repository.FixedExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonService {

  private final FixedExtensionRepository fixedExtensionRepository;
  private final CustomExtensionRepository customExtensionRepository;

  public void findExtension(String name) {
    FixedExtension findFixedExtension = fixedExtensionRepository.findByExtensionName(name);
    CustomExtension findCustomExtension = customExtensionRepository.findByCustomExtensionName(name);

    if ((findFixedExtension != null || findCustomExtension != null)) {
      throw new IllegalArgumentException("해당 확장자는 이미 존재하는 확장자입니다.");
    }
  }
}
