package com.example.Test.generix.dto;

public record SingleResponse<T>(T data) {

    public static <T> SingleResponse<T> of(T data) {
        return new SingleResponse<>(data);
    }

}
