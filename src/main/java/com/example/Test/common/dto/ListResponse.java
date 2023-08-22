package com.example.Test.common.dto;

import java.util.List;

public record ListResponse<T>(
        List<T> data,
        long totalElements
) {

    public static <T> ListResponse<T> of(List<T> data) {
        return new ListResponse<>(data, data.size());
    }

}
