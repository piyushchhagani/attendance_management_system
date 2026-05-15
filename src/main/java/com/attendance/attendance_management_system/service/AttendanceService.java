package com.attendance.attendance_management_system.service;

import com.attendance.attendance_management_system.dto.CheckInRequest;
import com.attendance.attendance_management_system.dto.CheckInResponse;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    public String getStatus() {
        return "UP";
    }

    public CheckInResponse checkIn(
            CheckInRequest request
    ) {

        String message =
                request.getName()
                        + " checked in successfully";

        return new CheckInResponse(message);
    }
}