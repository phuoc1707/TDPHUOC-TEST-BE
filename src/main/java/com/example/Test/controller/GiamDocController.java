package com.example.Test.controller;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/GiamDoc")
public class GiamDocController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            if (!isExcelFile(file)) {
                return "Chỉ cho phép file Excel";
            }
            String filePath = "D:\\" + file.getOriginalFilename();
            file.transferTo(new File(filePath));
            return "upload File thành công";
        } catch (IOException e) {
            e.printStackTrace();
            return "upload File thất bại";
        }
    }

    private boolean isExcelFile(MultipartFile file) {
        try {
            Workbook workbook = WorkbookFactory.create(file.getInputStream());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
