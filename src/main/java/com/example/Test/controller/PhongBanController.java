package com.example.Test.controller;

import com.example.Test.dto.request.PhongBanRequest;
import com.example.Test.dto.response.PhongBanResponse;
import com.example.Test.generix.controller.GenericController;
import com.example.Test.service.impl.PhongBanServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/PhongBan")
public class PhongBanController extends GenericController<Long, PhongBanRequest, PhongBanResponse> {

    @Override
    protected void initialize() {
        this.setService(PhongBanServiceImpl.class);
    }

}
