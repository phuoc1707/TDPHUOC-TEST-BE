package com.example.Test.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PhongBan")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhongBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PhongBanId", nullable = false)
    private Long id;

    @Column(name = "TenPhongBan")
    private String tenPhongBan;

    @Column(name = "ChucNang")
    private String chucNang;

    @OneToMany(mappedBy = "phongBan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<NhanVien> nhanViens = new ArrayList<>();
}
