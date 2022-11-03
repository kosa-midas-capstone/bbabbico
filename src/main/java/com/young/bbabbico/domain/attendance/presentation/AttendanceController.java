package com.young.bbabbico.domain.attendance.presentation;

import com.young.bbabbico.domain.attendance.presentation.dto.response.AttendanceListResponse;
import com.young.bbabbico.domain.attendance.service.GoToWorkService;
import com.young.bbabbico.domain.attendance.service.LeaveWorkService;
import com.young.bbabbico.domain.attendance.service.QueryDaysService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final QueryDaysService queryDaysService;
    private final GoToWorkService goToWorkService;
    private final LeaveWorkService leaveWorkService;

    @GetMapping
    public AttendanceListResponse queryAttendanceListResponse(@RequestParam String name, @RequestParam short month) {
        return queryDaysService.execute(name, month);
    }

    @PostMapping
    public void goToWork(@RequestParam String name) {
        goToWorkService.execute(name);
    }

    @DeleteMapping
    public void leaveWork(@RequestParam String name) {
        leaveWorkService.execute(name);
    }
}
