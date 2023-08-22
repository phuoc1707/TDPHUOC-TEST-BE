package com.example.Test.service.impl;

import com.example.Test.dto.projection.LuongNhanVien;
import com.example.Test.dto.request.NhanVienRequest;
import com.example.Test.dto.response.NhanVienResponse;
import com.example.Test.entity.NhanVien;
import com.example.Test.generix.service.GenericService;
import com.example.Test.mapper.NhanVienMapper;
import com.example.Test.repository.NhanVienRepository;
import com.example.Test.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl extends GenericService<NhanVien, Long, NhanVienRequest, NhanVienResponse> implements NhanVienService {

    private final NhanVienRepository repository;

    @Override
    protected void initialize() {
        this.setResourceName("NhanVien");
        this.setRepository(NhanVienRepository.class);
        this.setMapper(NhanVienMapper.class);
    }

    @Override
    public void updateBangLuongNhanVien(LuongNhanVien luongNhanVien) {
        repository.findByMaNv(luongNhanVien.getMaNv()).ifPresent(entity -> {
            entity.setLuong(luongNhanVien.getLuong());
            repository.save(entity);
        });
    }
}
