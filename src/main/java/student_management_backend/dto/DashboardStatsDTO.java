package student_management_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardStatsDTO {

    private long totalStudents;

    private long totalCourses;

    private long totalUsers;

    private long totalAdmins;

}