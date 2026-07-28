package student_management_backend.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import student_management_backend.entity.Course;
import student_management_backend.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Course addCourse(@Valid @RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Course updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody Course course) {

        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteCourse(@PathVariable Long id) {

        courseService.deleteCourse(id);

        return "Course Deleted Successfully";
    }

}