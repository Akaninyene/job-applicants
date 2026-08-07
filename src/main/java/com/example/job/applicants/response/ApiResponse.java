package com.example.job.applicants.response;

public class ApiResponse {
    private String message; // success, login failed
    private String status; // 00, E0, 01
    private Object data;

    // constructor for api response
    public ApiResponse( String message, String status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    // getter and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
