package com.flow.blockfileextension.service;

import com.flow.blockfileextension.dto.ExtensionRequest;
import com.flow.blockfileextension.dto.ExtensionResponse;

import java.util.List;

public interface FixedExtensionService {

  /**
   * 선택된 확장자 데이터 베이스 저장
   *
   * @param request
   * @return 저장된 확장자
   */
  ExtensionResponse createFixedExtension(ExtensionRequest request);

  /**
   * 저장한 확장자 전체 조회
   *
   * @return DB에 저장된 확장자 전체
   */
  List<ExtensionResponse> getAllFixedExtension();

  ;
}
