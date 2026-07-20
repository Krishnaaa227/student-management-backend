package student_management_backend.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import student_management_backend.dto.StudentDTO;
import jakarta.validation.Valid;

import java.util.List;
import student_management_backend.entity.Student;
import student_management_backend.service.StudentService;
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping
public ResponseEntity<StudentDTO> addStudent(
        @Valid @RequestBody Student student) {

    return ResponseEntity.status(HttpStatus.CREATED)
            .body(studentService.saveStudent(student));
}
    @GetMapping
public List<StudentDTO> getAllStudents() {
    return studentService.getAllStudents();
}
@GetMapping("/{id}")
public StudentDTO getStudentById(@PathVariable Long id) {
    return studentService.getStudentById(id);
}
@PutMapping("/{id}")
public StudentDTO updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
 
    return studentService.updateStudent(id, updatedStudent);
}
@DeleteMapping("/{id}")
public void deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
}
@GetMapping("/page")
public Page<StudentDTO> getStudents(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size) {

    return studentService.getStudents(page, size);
}
@GetMapping("/sort")
public List<StudentDTO> getStudentsSorted(
        @RequestParam String field,
        @RequestParam(defaultValue = "asc") String direction) {

    return studentService.getStudentsSorted(field, direction);
}
@GetMapping("/course/{course}")
public List<StudentDTO> getStudentsByCourse(@PathVariable String course) {
    return studentService.getStudentsByCourse(course);
}
}

