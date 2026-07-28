package student_management_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import student_management_backend.dto.CourseChartDTO;
import student_management_backend.dto.DashboardStatsDTO;
import student_management_backend.service.DashboardService;

@RestController
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard/stats")
    public DashboardStatsDTO getDashboardStats() {

        return dashboardService.getStats();

    }
    @GetMapping("/dashboard/course-chart")
public List<CourseChartDTO> getCourseChart() {
    return dashboardService.getStudentsByCourse();
}
}