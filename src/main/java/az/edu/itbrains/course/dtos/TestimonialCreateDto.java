package az.edu.itbrains.course.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestimonialCreateDto {
    @NotBlank
    private String studentName;

    private String content;
}