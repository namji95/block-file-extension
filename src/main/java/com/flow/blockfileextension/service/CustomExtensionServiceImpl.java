package com.flow.blockfileextension.service;

import com.flow.blockfileextension.common.CommonService;
import com.flow.blockfileextension.dto.ExtensionRequest;
import com.flow.blockfileextension.dto.ExtensionResponse;
import com.flow.blockfileextension.entity.CustomExtension;
import com.flow.blockfileextension.exception.CustomException;
import com.flow.blockfileextension.exception.ErrorCode;
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
  public void createCustomExtension(ExtensionRequest request) {
    commonService.findExtension(request.getExtensionName());
    List<CustomExtension> customExtensions = customExtensionRepository.findAll();

    if (customExtensions.size() < 201) {
      throw new CustomException(ErrorCode.RANGE_LIMIT);
    }

    CustomExtension customExtension = new CustomExtension(request.getExtensionName());

    customExtensionRepository.save(customExtension);
  }

  @Override
  public List<ExtensionResponse> getAllCustomExtension() {
    List<ExtensionResponse> responses = new ArrayList<>();
    List<CustomExtension> findCustomExtension = customExtensionRepository.findAll();

    if (findCustomExtension.isEmpty()) {
      throw new CustomException(ErrorCode.NOT_FOUND_EXTENSION);
    }

    for (CustomExtension customExtension : findCustomExtension) {
      responses.add(new ExtensionResponse(customExtension.getCustomExtensionName()));
    }

    return responses;
  }

  @Override
  public void deleteCustomExtension(ExtensionRequest request) {
    CustomExtension deleteCustomExtension =
        customExtensionRepository.findByCustomExtensionName(request.getExtensionName());

    if (deleteCustomExtension == null) {
      throw new CustomException(ErrorCode.NOT_FOUND_EXTENSION);
    }

    customExtensionRepository.delete(deleteCustomExtension);
  }
}
