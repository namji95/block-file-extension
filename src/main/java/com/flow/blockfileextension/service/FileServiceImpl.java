package com.flow.blockfileextension.service;

import com.flow.blockfileextension.entity.CustomExtension;
import com.flow.blockfileextension.entity.File;
import com.flow.blockfileextension.entity.FixedExtension;
import com.flow.blockfileextension.exception.CustomException;
import com.flow.blockfileextension.exception.ErrorCode;
import com.flow.blockfileextension.repository.CustomExtensionRepository;
import com.flow.blockfileextension.repository.FileRepository;
import com.flow.blockfileextension.repository.FixedExtensionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

  private final FileRepository fileRepository;
  private final FixedExtensionRepository fixedExtensionRepository;
  private final CustomExtensionRepository customExtensionRepository;

  @Override
  public String saveFile(MultipartFile file) throws IOException {
    float megabytes = (float) file.getSize() / 1024 / 1024;
    if (megabytes > 10) {
      throw new CustomException(ErrorCode.FILE_SIZE_LIMIT);
    }

    if (file.isEmpty()) {
      throw new CustomException(ErrorCode.FILE_NOT_EXIST);
    }

    // 파일 확장자 검증
    extensionExtraction(file);
    duplicateFile(file);

    File folder = new File(
        file.getOriginalFilename(),
        file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".")),
        file.getContentType().substring(file.getContentType().lastIndexOf("/") + 1)
    );

    fileRepository.save(folder);

    return file.getOriginalFilename() + "파일이 저장되었습니다.";
  }

  // 확장자 존재 여부
  private void extensionExtraction (MultipartFile file) {
    if (!file.getOriginalFilename().contains(".") || !file.getContentType().contains("/")) {
      throw new CustomException(ErrorCode.EXTENSION_NOT_EXIST);
    }

    String extensionExtraction = file.getOriginalFilename()
        .substring(file.getOriginalFilename().lastIndexOf(".") + 1);

    gapExtension(extensionExtraction);
    findBlockExtension(extensionExtraction);
  }

  // 확장자 형식 체크
  private void gapExtension(String extension) {
    if (!extension.matches("^[a-zA-Z]*$")) {
      throw new CustomException(ErrorCode.EXTENSION_NAME_FORM);
    }
  }


  // 차단된 확장자 여부
  private void findBlockExtension (String extensionExtraction) {
    CustomExtension customExtension = customExtensionRepository.findByCustomExtensionName(extensionExtraction);
    FixedExtension fixedExtension = fixedExtensionRepository.findByExtensionName(extensionExtraction);

    if (customExtension != null || fixedExtension != null) {
      throw new CustomException(ErrorCode.BLOCKED_EXTENSION);
    }
  }

  // 중복 여부
  private void duplicateFile(MultipartFile file) {
    File originalFile = fileRepository.findByOriginalFilename(file.getOriginalFilename());

    if (originalFile != null) {
      throw new CustomException(ErrorCode.DUPLICATE_FILE);
    }
  }
}