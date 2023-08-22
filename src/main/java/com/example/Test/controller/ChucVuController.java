package com.example.Test.controller;

import com.example.Test.dto.request.ChucVuRequest;
import com.example.Test.dto.response.ChucVuResponse;
import com.example.Test.generix.controller.GenericController;
import com.example.Test.service.impl.ChucVuServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ChucVu")
public class ChucVuController extends GenericController<Long, ChucVuRequest, ChucVuResponse> {

    @Override
    protected void initialize() {
        this.setService(ChucVuServiceImpl.class);
    }

}
