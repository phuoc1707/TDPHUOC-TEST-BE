package com.example.Test.mapper;

import com.example.Test.dto.request.ChucVuRequest;
import com.example.Test.dto.response.ChucVuResponse;
import com.example.Test.entity.ChucVu;
import com.example.Test.generix.mapper.GenericMapper;
import com.example.Test.generix.mapper.ReferenceMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {ReferenceMapper.class})
public abstract class ChucVuMapper implements GenericMapper< ChucVu, ChucVuRequest,  ChucVuResponse> {
}
