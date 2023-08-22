package com.example.Test.enumaration;

public enum TrangThai {
    DaNghiViec("Đã nghỉ việc"),
    NghiPhep("Nghỉ phép"),
    HoatDong("Hoạt động");

    private final String name;

    TrangThai(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
