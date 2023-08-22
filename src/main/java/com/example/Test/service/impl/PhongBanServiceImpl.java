package com.example.Test.service.impl;

import com.example.Test.dto.request.PhongBanRequest;
import com.example.Test.dto.response.PhongBanResponse;
import com.example.Test.entity.PhongBan;
import com.example.Test.generix.service.GenericService;
import com.example.Test.mapper.PhongBanMapper;
import com.example.Test.repository.PhongBanRepository;
import com.example.Test.service.PhongBanService;
import org.springframework.stereotype.Service;

@Service
public class PhongBanServiceImpl extends GenericService<PhongBan, Long, PhongBanRequest, PhongBanResponse> implements PhongBanService {

    @Override
    protected void initialize() {
        this.setResourceName("PhongBan");
        this.setRepository(PhongBanRepository.class);
        this.setMapper(PhongBanMapper.class);
        this.setSearchFields("tenPhongBan", "chucNang");
    }

}
