package az.edu.itbrains.course.dtos.create;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TestimonialCreateDto {
    @NotBlank
    private String studentName;

    private String content;
}