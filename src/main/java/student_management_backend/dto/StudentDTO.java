package student_management_backend.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class StudentDTO {

    private Long id;   // <-- ADD THIS

    @NotBlank(message = "Roll Number is required")
    private String rollNo;

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @Email(message = "Please enter a valid email")
    @NotBlank(message = "Email is required")
    private String email;

    @Pattern(
        regexp = "^[0-9]{10}$",
        message = "Phone number must contain exactly 10 digits"
    )
    private String phone;

    @NotBlank(message = "Course is required")
    private String course;

    @NotNull(message = "Semester is required")
    private Integer semester;
}