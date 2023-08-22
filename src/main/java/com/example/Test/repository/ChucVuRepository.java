package com.example.Test.repository;

import com.example.Test.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChucVuRepository extends JpaRepository<ChucVu, Long>, JpaSpecificationExecutor<ChucVu> {
}
