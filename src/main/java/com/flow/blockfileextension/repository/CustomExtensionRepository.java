package com.flow.blockfileextension.repository;

import com.flow.blockfileextension.entity.CustomExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomExtensionRepository extends JpaRepository<CustomExtension, Long> {

  CustomExtension findByCustomExtensionName(String extensionName);
}
