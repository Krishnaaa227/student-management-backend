package student_management_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course Name is required")
    @Column(unique = true)
    private String courseName;

    @NotBlank(message = "Course Code is required")
    @Column(unique = true)
    private String courseCode;

}