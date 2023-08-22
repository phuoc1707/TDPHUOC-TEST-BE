package com.example.Test.dto.response;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PhongBanResponse {
    private Long id;
    private String tenPhongBan;
    private String chucNang;
}
