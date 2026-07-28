package student_management_backend.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import student_management_backend.entity.Course;
import student_management_backend.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Get All Courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Add Course
    public Course addCourse(Course course) {

        if (courseRepository.findByCourseName(course.getCourseName()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Course name already exists"
            );
        }

        if (courseRepository.findByCourseCode(course.getCourseCode()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Course code already exists"
            );
        }

        return courseRepository.save(course);
    }

    // Update Course
    public Course updateCourse(Long id, Course updatedCourse) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Course not found"));

        course.setCourseName(updatedCourse.getCourseName());
        course.setCourseCode(updatedCourse.getCourseCode());

        return courseRepository.save(course);
    }

    // Delete Course
    public void deleteCourse(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Course not found"));

        courseRepository.delete(course);
    }

}