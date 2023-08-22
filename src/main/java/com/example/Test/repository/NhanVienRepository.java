package com.example.Test.repository;

import com.example.Test.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface NhanVienRepository extends JpaRepository<NhanVien, Long>, JpaSpecificationExecutor<NhanVien> {
    NhanVien findFirstByOrderByIdDesc();

    Optional<NhanVien> findByMaNv(String maNv);
}
