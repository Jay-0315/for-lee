package com.kakeibo.global.response;

//공통 api 응답 포멧
public record ApiResponse<T>(
    boolean success,
    String message,
    T data
) {
    //ApiResponse<T> 모든 api 응답 포맷 통일
    
    //success response
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data);
    }

    //success response without data
    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>(true, message, null);
    }

    //failure response
    public static <T> ApiResponse<T> failure(String message) {
        return new ApiResponse<>(false, message, null);
    }
}
