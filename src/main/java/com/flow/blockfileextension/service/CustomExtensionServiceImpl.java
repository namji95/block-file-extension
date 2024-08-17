package com.flow.blockfileextension.service;

import com.flow.blockfileextension.common.CommonService;
import com.flow.blockfileextension.dto.ExtensionRequest;
import com.flow.blockfileextension.dto.ExtensionResponse;
import com.flow.blockfileextension.entity.CustomExtension;
import com.flow.blockfileextension.repository.CustomExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomExtensionServiceImpl implements CustomExtensionService{

  private final CustomExtensionRepository customExtensionRepository;
  private final CommonService commonService;

  @Override
  public ExtensionResponse createCustomExtension(ExtensionRequest request) {
    commonService.findExtension(request.getExtensionName());
    List<CustomExtension> customExtensions = customExtensionRepository.findAll();

    if (customExtensions.size() == 200) {
      throw new IllegalArgumentException("확장자를 더 이상 추가할 수 없습니다.");
    }

    CustomExtension customExtension = new CustomExtension(request.getExtensionName());

    CustomExtension saveCustomExtension = customExtensionRepository.save(customExtension);

    return new ExtensionResponse(saveCustomExtension.getCustomExtensionName());
  }

  @Override
  public List<ExtensionResponse> getAllCustomExtension() {
    List<ExtensionResponse> responses = new ArrayList<>();
    List<CustomExtension> findCustomExtension = customExtensionRepository.findAll();

    if (findCustomExtension.isEmpty()) {
      throw new IllegalArgumentException("존재하는 확장자가 없습니다.");
    }

    for (CustomExtension customExtension : findCustomExtension) {
      responses.add(new ExtensionResponse(customExtension.getCustomExtensionName()));
    }

    return responses;
  }

  @Override
  public ExtensionResponse deleteCustomExtension(ExtensionRequest request) {
    CustomExtension deleteCustomExtension =
        customExtensionRepository.findByCustomExtensionName(request.getExtensionName());

    if (deleteCustomExtension == null) {
      throw new IllegalArgumentException("해당 확장자는 존재하지 않습니다.");
    }

    customExtensionRepository.delete(deleteCustomExtension);

    return new ExtensionResponse(deleteCustomExtension.getCustomExtensionName());
  }
}
