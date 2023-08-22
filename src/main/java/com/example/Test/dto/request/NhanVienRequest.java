package com.example.Test.dto.request;

import com.example.Test.enumaration.TrangThai;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.Instant;

@Data
public class NhanVienRequest {
    @JsonIgnore
    private String maNv;
    private String hoVaTen;
    private Instant ngaySinh;
    private String queQuan;
    private String SDT;
    private String email;
    private Long phongBanId;
    private Long chucVuId;
    private Double luong;
    private TrangThai trangThai;
}
