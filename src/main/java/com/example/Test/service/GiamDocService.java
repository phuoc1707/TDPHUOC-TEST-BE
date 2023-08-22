package com.example.Test.service;

import com.example.Test.dto.projection.LuongNhanVien;

import java.util.List;

public interface GiamDocService {
        String getLuongThangHienTaiCuaNamHienTai();
        List<LuongNhanVien> getListData();
}
