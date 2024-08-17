package com.flow.blockfileextension.service;

import com.flow.blockfileextension.dto.ExtensionRequest;
import com.flow.blockfileextension.dto.ExtensionResponse;

import java.util.List;

public interface FixedExtensionService {

  /**
   * 선택된 고정 확장자 데이터 베이스 저장
   * @param request 선택한 확장자 이름
   * @return 저장된 확장자
   */
  void createFixedExtension(ExtensionRequest request);

  /**
   * 저장한 고정 확장자 전체 조회
   *
   * @return DB에 저장된 확장자 전체
   */
  List<ExtensionResponse> getAllFixedExtension();

  /**
   * 저장한 고정 확장자 삭제
   * @param request 선택한 확장자 이름
   * @return 삭제된 고정 확장자
   */
  void deleteFixedExtension(ExtensionRequest request);
}
