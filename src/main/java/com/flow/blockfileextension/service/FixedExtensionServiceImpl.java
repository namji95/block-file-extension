package com.flow.blockfileextension.service;

import com.flow.blockfileextension.common.CommonService;
import com.flow.blockfileextension.dto.ExtensionRequest;
import com.flow.blockfileextension.dto.ExtensionResponse;
import com.flow.blockfileextension.entity.FixedExtension;
import com.flow.blockfileextension.repository.FixedExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FixedExtensionServiceImpl implements FixedExtensionService {

  private final FixedExtensionRepository fixedExtensionRepository;
  private final CommonService commonService;

  @Transactional
  @Override
  public ExtensionResponse createFixedExtension(ExtensionRequest request) {
    commonService.findExtension(request.getExtensionName());

    FixedExtension fixedExtension = new FixedExtension(request.getExtensionName());

    FixedExtension saveFixedExtension = fixedExtensionRepository.save(fixedExtension);

    return new ExtensionResponse(saveFixedExtension.getExtensionName());
  }

  @Transactional(readOnly = true)
  @Override
  public List<ExtensionResponse> getAllFixedExtension() {
    List<ExtensionResponse> responses = new ArrayList<>();
    List<FixedExtension> fixedExtension = fixedExtensionRepository.findAll();

    if (fixedExtension.isEmpty()) {
      throw new IllegalArgumentException("존재하는 확장자가 없습니다.");
    }

    for (FixedExtension extension : fixedExtension) {
      responses.add(new ExtensionResponse(extension.getExtensionName()));
    }

    return responses;
  }

  @Transactional
  @Override
  public ExtensionResponse deleteFixedExtension(ExtensionRequest request) {
    FixedExtension deleteExtension = fixedExtensionRepository.findByExtensionName(request.getExtensionName());

    if (deleteExtension == null) {
      throw new IllegalArgumentException("해당 확장자는 존재하지 않습니다.");
    }

    fixedExtensionRepository.delete(deleteExtension);

    return new ExtensionResponse(deleteExtension.getExtensionName());
  }
}
