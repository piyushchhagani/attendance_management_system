package com.attendance.attendance_management_system;

import com.attendance.attendance_management_system.dto.CheckInRequest;
import com.attendance.attendance_management_system.dto.CheckInResponse;
import com.attendance.attendance_management_system.service.AttendanceService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AttendanceServiceTest {

    AttendanceService attendanceService =
            new AttendanceService();

    @Test
    void testStatus() {

        String status =
                attendanceService.getStatus();

        assertEquals("UP", status);
    }

    @Test
    void testCheckIn() {

        CheckInRequest request =
                new CheckInRequest("Piyush");

        CheckInResponse response =
                attendanceService.checkIn(request);

        assertTrue(
                response.getMessage()
                        .contains("checked in successfully")
        );
    }
}