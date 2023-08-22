package com.example.Test.entity;

import com.example.Test.enumaration.TrangThai;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Entity
@Table(name = "NhanVien")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NhanVien {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MaNV", nullable = false, length = 6)
    private String maNv;

    @Column(name = "HoVaTen")
    private String hoVaTen;

    @Column(name = "NgaySinh")
    private Instant ngaySinh;

    @Column(name = "QueQuan")
    private String queQuan;

    @Column(name = "SDT")
    private String SDT;

    @Column(name = "Email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PhongBanId")
    @JsonBackReference
    private PhongBan phongBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ChucVuId")
    @JsonBackReference
    private ChucVu chucVu;

    @Column(name = "Luong")
    private Double luong;

    @Column(name = "TrangThai")
    @Enumerated(EnumType.STRING)
    private TrangThai trangThai;
}
