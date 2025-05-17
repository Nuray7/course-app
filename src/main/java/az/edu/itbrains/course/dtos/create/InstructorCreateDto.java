package az.edu.itbrains.course.dtos.create;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class InstructorCreateDto {
    @NotBlank
    private String name;

    private String bio;
    private String imageUrl;
}
