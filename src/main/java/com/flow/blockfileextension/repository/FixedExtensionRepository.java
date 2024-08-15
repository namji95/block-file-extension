package com.flow.blockfileextension.repository;

import com.flow.blockfileextension.entity.FixedExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedExtensionRepository extends JpaRepository<FixedExtension, Long> {
  FixedExtension findByExtensionName(String name);
}
