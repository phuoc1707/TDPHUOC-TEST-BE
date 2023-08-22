package com.example.Test.mapper;

import com.example.Test.dto.request.PhongBanRequest;
import com.example.Test.dto.response.PhongBanResponse;
import com.example.Test.entity.PhongBan;
import com.example.Test.generix.mapper.GenericMapper;
import com.example.Test.generix.mapper.ReferenceMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {ReferenceMapper.class})
public abstract class PhongBanMapper implements GenericMapper<PhongBan, PhongBanRequest, PhongBanResponse> {
}
