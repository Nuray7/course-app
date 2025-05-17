package az.edu.itbrains.course.dtos.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentCreateDto {
    @NotBlank
    private String name;

    @Email
    private String email;

    private boolean isNew;
}
