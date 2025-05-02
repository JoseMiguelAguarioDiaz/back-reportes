package com.example.demo.kernel;

import org.springframework.http.HttpStatus;

public class ResponseApi {
    private Object data;
    private HttpStatus status;
    private boolean error;
    private String message;

    public ResponseApi(Object data, HttpStatus status) {
        this.data = data;
        this.status = status;
    }

    public ResponseApi(Object data, HttpStatus status, boolean error, String message) {
        this.data = data;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
