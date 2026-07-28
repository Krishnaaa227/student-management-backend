package student_management_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseChartDTO {

    private String course;

    private Long totalStudents;

}