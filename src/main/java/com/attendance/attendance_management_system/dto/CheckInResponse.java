package com.attendance.attendance_management_system.dto;

public class CheckInResponse {

    private String message;

    public CheckInResponse() {
    }

    public CheckInResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}