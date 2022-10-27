package com.wladmir.productsapi.handler;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {
    private HttpStatus statusCode = HttpStatus.CONFLICT;

    public BusinessException(String mensagem, HttpStatus status) {
        super(mensagem);
        this.statusCode = status;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public BusinessException(String mensagem, Object... params) {
        super(String.format(mensagem, params));
    }
}

