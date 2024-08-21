package com.flow.blockfileextension.common;

import com.flow.blockfileextension.entity.CustomExtension;
import com.flow.blockfileextension.entity.FixedExtension;
import com.flow.blockfileextension.exception.CustomException;
import com.flow.blockfileextension.exception.ErrorCode;
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
      throw new CustomException(ErrorCode.DUPLICATE_EXTENSION);
    }
  }
}
