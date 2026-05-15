package com.attendance.attendance_management_system.dto;

public class CheckInRequest {

    private String name;

    public CheckInRequest() {
    }

    public CheckInRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}