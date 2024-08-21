package com.flow.blockfileextension.service;

import com.flow.blockfileextension.dto.ExtensionRequest;
import com.flow.blockfileextension.dto.ExtensionResponse;

import java.util.List;

public interface CustomExtensionService {

  /**
   * 입력된 커스텀 확장자 저장
   *
   * @param request 커스텀 확장자 이름
   * @return 저장 완료된 커스텀 확장자
   */
  void createCustomExtension(ExtensionRequest request);

  /**
   * 저장된 커스텀 확장자 전체 조회
   *
   * @return DB에 저장된 커스텀 확장자
   */
  List<ExtensionResponse> getAllCustomExtension();

  /**
   * 선택된 커스텀 확장자 삭제
   *
   * @param request 선택된 커스텀 확장자 이름
   * @return 삭제된 커스텀 확장자 이름
   */
  void deleteCustomExtension(ExtensionRequest request);

}
