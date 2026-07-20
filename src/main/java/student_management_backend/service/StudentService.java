package student_management_backend.service;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.lang.NonNull;
import student_management_backend.dto.StudentDTO;
import student_management_backend.entity.Student;
import student_management_backend.repository.StudentRepository;
import student_management_backend.exception.StudentNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
@Service

public class StudentService {
    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

public StudentService(StudentRepository studentRepository,
                      ModelMapper modelMapper) {
    this.studentRepository = studentRepository;
    this.modelMapper = modelMapper;
}
    public StudentDTO saveStudent(@NonNull Student student) {

    Student savedStudent = studentRepository.save(student);

    return modelMapper.map(savedStudent, StudentDTO.class);
}

public StudentDTO getStudentById(@NonNull Long id) {

    Student student = studentRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("Student not found"));

    return modelMapper.map(student, StudentDTO.class);
}
public StudentDTO updateStudent(@NonNull Long id, Student updatedStudent) {

    Student existingStudent = studentRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("Student not found"));

    existingStudent.setRollNo(updatedStudent.getRollNo());
    existingStudent.setFirstName(updatedStudent.getFirstName());
    existingStudent.setLastName(updatedStudent.getLastName());
    existingStudent.setEmail(updatedStudent.getEmail());
    existingStudent.setPhone(updatedStudent.getPhone());
    existingStudent.setCourse(updatedStudent.getCourse());
    existingStudent.setSemester(updatedStudent.getSemester());

    Student savedStudent = studentRepository.save(existingStudent);

    return modelMapper.map(savedStudent, StudentDTO.class);
}
public void deleteStudent(@NonNull Long id) {
    studentRepository.deleteById(id);
}
public List<StudentDTO> getAllStudents() {

    return studentRepository.findAll()
            .stream()
            .map(student -> modelMapper.map(student, StudentDTO.class))
            .toList();
}
public Page<StudentDTO> getStudents(int page, int size) {

    Pageable pageable = PageRequest.of(page, size);

    Page<Student> students = studentRepository.findAll(pageable);

    return students.map(student -> modelMapper.map(student, StudentDTO.class));
}
public List<StudentDTO> getStudentsSorted(String field, String direction) {

    Sort sort = direction.equalsIgnoreCase("desc")
            ? Sort.by(field).descending()
            : Sort.by(field).ascending();

    return studentRepository.findAll(sort)
            .stream()
            .map(student -> modelMapper.map(student, StudentDTO.class))
            .toList();
}
public List<StudentDTO> getStudentsByCourse(String course) {

    return studentRepository.findByCourse(course)
            .stream()
            .map(student -> modelMapper.map(student, StudentDTO.class))
            .toList();
}

}
