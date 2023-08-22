package com.example.Test.dto.projection;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LuongNhanVien {
    private String maNv;
    private Double luong;
}
