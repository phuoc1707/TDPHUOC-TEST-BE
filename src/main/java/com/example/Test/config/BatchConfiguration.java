package com.example.Test.config;

import com.example.Test.dto.projection.LuongNhanVien;
import com.example.Test.service.GiamDocService;
import com.example.Test.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
public class BatchConfiguration {
    @Autowired
    private  GiamDocService giamDocService;
    @Autowired
    private  NhanVienService nhanVienService;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private  PlatformTransactionManager transactionManager;

    public ItemReader<LuongNhanVien> itemReader() {
        List<LuongNhanVien> dataToUpdateList = giamDocService.getListData();
        return new ListItemReader<>(dataToUpdateList);
    }


    public ItemWriter<LuongNhanVien> itemWriter() {
        return items -> {
            for (LuongNhanVien item : items) {
                nhanVienService.updateBangLuongNhanVien(item);
            }
        };
    }


    public Step step(ItemReader<LuongNhanVien> itemReader, ItemWriter<LuongNhanVien> itemWriter) {
        return new StepBuilder("step",jobRepository)
                .<LuongNhanVien, LuongNhanVien>chunk(100,transactionManager)
                .reader(itemReader)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public Job job() {
        return new JobBuilder("job",jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step(itemReader(),itemWriter()))
                .build();
    }

}
