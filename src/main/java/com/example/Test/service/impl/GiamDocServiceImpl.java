package com.example.Test.service.impl;

import com.example.Test.dto.projection.LuongNhanVien;
import com.example.Test.service.GiamDocService;
import com.example.Test.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GiamDocServiceImpl implements GiamDocService {

    @Override
    public String getLuongThangHienTaiCuaNamHienTai() {
        LocalDate currentDate = LocalDate.now();
        String monthYear = currentDate.format(DateTimeFormatter.ofPattern("MM_yyyy"));
        return "BangLuongThang_" + monthYear;
    }

    @Override
    public List<LuongNhanVien> getListData() {
        String fileName = getLuongThangHienTaiCuaNamHienTai();
        String filePath = "D:\\" + fileName;
        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath+".xlsx"));
             Workbook workbook = WorkbookFactory.create(fileInputStream))
        {
            return readAndUpdateData(workbook);
        } catch (Exception e) {
            try (FileInputStream fileInputStream = new FileInputStream(new File(filePath+".xlx"));
                 Workbook workbook = WorkbookFactory.create(fileInputStream))
            {
                return readAndUpdateData(workbook);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }

    List<LuongNhanVien> readAndUpdateData(Workbook workbook){
        Sheet sheet = workbook.getSheetAt(0);
        List<LuongNhanVien> luongNhanViens = new ArrayList<>();

        int count = 0;

        for (Row row : sheet) {
            count++;
            if(count == 1){
                continue;
            }

            LuongNhanVien luongNhanVien = LuongNhanVien.builder().build();
            for (Cell cell : row) {
                int cellColumnIndex = cell.getColumnIndex();
                if (cellColumnIndex == 0) {
                    String maNv = cell.getStringCellValue();
                    luongNhanVien.setMaNv(maNv);
                } else if (cellColumnIndex == 1) {
                    double luong = cell.getNumericCellValue();
                    luongNhanVien.setLuong(luong);
                }
            }
            luongNhanViens.add(luongNhanVien);
        }

        return luongNhanViens;
    }
}
