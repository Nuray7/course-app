package az.edu.itbrains.course.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorCreateDto {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Bio cannot be blank")
    private String bio;

    private String imageUrl;
}
