package com.example.Test.service.impl;

import com.example.Test.dto.request.ChucVuRequest;
import com.example.Test.dto.response.ChucVuResponse;
import com.example.Test.entity.ChucVu;
import com.example.Test.generix.service.GenericService;
import com.example.Test.mapper.ChucVuMapper;
import com.example.Test.repository.ChucVuRepository;
import com.example.Test.service.ChucVuService;
import org.springframework.stereotype.Service;

@Service
public class ChucVuServiceImpl extends GenericService<ChucVu, Long, ChucVuRequest, ChucVuResponse> implements ChucVuService {

    @Override
    protected void initialize() {
        this.setResourceName("ChucVu");
        this.setRepository(ChucVuRepository.class);
        this.setMapper(ChucVuMapper.class);
        this.setSearchFields("tenChucVu", "thamQuyen");
    }

}
