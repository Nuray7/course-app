package az.edu.itbrains.course.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class StudentCreateDto {
    @NotBlank
    private String name;

    @Email
    private String email;

    private boolean isNew;
}
