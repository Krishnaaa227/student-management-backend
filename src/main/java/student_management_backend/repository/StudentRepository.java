package student_management_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import student_management_backend.dto.CourseChartDTO;
import student_management_backend.entity.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourse(String course);   
    @Query("""
SELECT new student_management_backend.dto.CourseChartDTO(
s.course,
COUNT(s)
)
FROM Student s
GROUP BY s.course
""")
List<CourseChartDTO> getStudentsByCourse();
}
