package com.example.Test.controller;

import com.example.Test.dto.request.NhanVienRequest;
import com.example.Test.dto.response.NhanVienResponse;
import com.example.Test.generix.controller.GenericController;
import com.example.Test.service.impl.NhanVienServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/NhanVien")
public class NhanVienController extends GenericController<Long, NhanVienRequest, NhanVienResponse> {

    @Override
    protected void initialize() {
        this.setService(NhanVienServiceImpl.class);
    }

}
