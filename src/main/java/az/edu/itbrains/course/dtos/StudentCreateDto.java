package az.edu.itbrains.course.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateDto {
    @NotBlank
    private String name;

    @Email
    private String email;

    private boolean isNew;
}
