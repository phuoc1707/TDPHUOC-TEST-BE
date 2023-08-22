package com.example.Test.mapper;

import com.example.Test.dto.request.NhanVienRequest;
import com.example.Test.dto.response.NhanVienResponse;
import com.example.Test.entity.NhanVien;
import com.example.Test.generix.mapper.GenericMapper;
import com.example.Test.generix.mapper.ReferenceMapper;
import com.example.Test.repository.NhanVienRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;

@Mapper(uses = {ReferenceMapper.class, ChucVuMapper.class, PhongBanMapper.class})
public abstract class NhanVienMapper implements GenericMapper<NhanVien, NhanVienRequest, NhanVienResponse> {

    @Autowired
    private ChucVuMapper chucVuMapper;
    @Autowired
    private PhongBanMapper phongBanMapper;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Override
    @Mapping(source = "chucVuId", target = "chucVu")
    @Mapping(source = "phongBanId", target = "phongBan")
    public NhanVien requestToEntity(NhanVienRequest request){
        if ( request == null ) {
            return null;
        }

        NhanVien nhanVien = new NhanVien();

        nhanVien.setMaNv(generateMaNV());
        nhanVien.setChucVu( chucVuMapper.idToEntity( request.getChucVuId() ) );
        nhanVien.setPhongBan( phongBanMapper.idToEntity( request.getPhongBanId() ) );
        nhanVien.setHoVaTen( request.getHoVaTen() );
        nhanVien.setNgaySinh( request.getNgaySinh() );
        nhanVien.setQueQuan( request.getQueQuan() );
        nhanVien.setSDT( request.getSDT() );
        nhanVien.setEmail( request.getEmail() );
        nhanVien.setLuong( request.getLuong() );
        nhanVien.setTrangThai( request.getTrangThai() );

        return nhanVien;
    };

    private String generateMaNV(){
        String maNvCuoi = nhanVienRepository.findFirstByOrderByIdDesc().getMaNv();
        int number = Integer.parseInt(maNvCuoi);
        number++;
        DecimalFormat decimalFormat = new DecimalFormat("000000");

        return decimalFormat.format(number);
    }
}
