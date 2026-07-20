package student_management_backend.dto;

import lombok.Data;

@Data
public class StudentDTO {

    private Long id;
    private String rollNo;
    private String firstName;
    private String lastName;
    private String email;
    private String course;
    private Integer semester;
    
}