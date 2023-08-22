package com.example.Test.generix.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public record PagedListResponse<T>(
        List<T> data,
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean last
) {

    public static <T, E> PagedListResponse<T> of(List<T> data, Page<E> page) {
        return new PagedListResponse<>(
                data,
                page.getNumber() + 1,
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isLast()
        );
    }

}
