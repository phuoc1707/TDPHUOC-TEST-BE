package com.example.Test.repository;

import com.example.Test.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PhongBanRepository extends JpaRepository<PhongBan, Long>, JpaSpecificationExecutor<PhongBan> {
}
