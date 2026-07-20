package student_management_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import student_management_backend.entity.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourse(String course);   
}
