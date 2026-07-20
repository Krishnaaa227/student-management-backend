package student_management_backend.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String username;
    private String password;

}