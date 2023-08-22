package com.example.Test.dto.response;

import com.example.Test.enumaration.TrangThai;
import lombok.Data;

import java.time.Instant;

@Data
public class NhanVienResponse {
    private Long id;
    private String maNv;
    private String hoVaTen;
    private Instant ngaySinh;
    private String queQuan;
    private String SDT;
    private String email;
    private PhongBanResponse phongBan;
    private ChucVuResponse chucVu;
    private Double luong;
    private TrangThai trangThai;
}
