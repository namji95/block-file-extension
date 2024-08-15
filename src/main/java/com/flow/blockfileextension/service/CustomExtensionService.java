package com.flow.blockfileextension.service;

import com.flow.blockfileextension.dto.ExtensionRequest;
import com.flow.blockfileextension.dto.ExtensionResponse;

import java.util.List;

public interface CustomExtensionService {

  ExtensionResponse createCustomExtension(ExtensionRequest request);

  List<ExtensionResponse> getAllCustomExtension();

}
