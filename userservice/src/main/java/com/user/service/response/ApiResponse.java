package com.user.service.response;

import lombok.Data;

@Data
public class ApiResponse {
    private Integer code;
    private String status;
    private String message;

    public ApiResponse(Integer code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
