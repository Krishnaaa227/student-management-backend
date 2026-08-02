package student_management_backend.service;

import org.springframework.stereotype.Service;
import java.util.List;
import student_management_backend.dto.CourseChartDTO;
import student_management_backend.dto.DashboardStatsDTO;
import student_management_backend.repository.CourseRepository;
import student_management_backend.repository.StudentRepository;
import student_management_backend.repository.UserRepository;

@Service
public class DashboardService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public DashboardService(
            StudentRepository studentRepository,
            CourseRepository courseRepository,
            UserRepository userRepository) {

        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public DashboardStatsDTO getStats() {

    long admins = userRepository.findAll()
            .stream()
            .filter(user -> user.getRole().equals("ADMIN"))
            .count();

    long totalSemesters = studentRepository.findAll()
            .stream()
            .map(student -> student.getSemester())
            .distinct()
            .count();

    return new DashboardStatsDTO(

            studentRepository.count(),

            courseRepository.count(),

            totalSemesters,

            admins

    );

    }
    public List<CourseChartDTO> getStudentsByCourse() {
    return studentRepository.getStudentsByCourse();
}

}