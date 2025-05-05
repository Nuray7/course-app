package az.edu.itbrains.course.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ContactMessageDto {
    @NotBlank
    private String name;

    @Email
    private String email;

    private String subject;
    private String message;
}
