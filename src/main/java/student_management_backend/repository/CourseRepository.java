package student_management_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import student_management_backend.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByCourseName(String courseName);

    Optional<Course> findByCourseCode(String courseCode);

}