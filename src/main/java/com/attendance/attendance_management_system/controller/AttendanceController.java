package com.attendance.attendance_management_system.controller;

import com.attendance.attendance_management_system.dto.CheckInRequest;
import com.attendance.attendance_management_system.dto.CheckInResponse;
import com.attendance.attendance_management_system.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(
            AttendanceService attendanceService
    ) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/status")
    public Map<String, String> getStatus() {

        Map<String, String> response =
                new HashMap<>();

        response.put(
                "status",
                attendanceService.getStatus()
        );

        return response;
    }

    @PostMapping("/checkin")
    public CheckInResponse checkIn(
            @RequestBody CheckInRequest request
    ) {

        return attendanceService.checkIn(request);
    }
}