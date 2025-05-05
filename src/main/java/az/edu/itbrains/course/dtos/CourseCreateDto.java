package az.edu.itbrains.course.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseCreateDto {
    @NotBlank
    private String title;

    private String description;
    private String category;
    private String imageUrl;

    private boolean isNew;
    private boolean isPopular;

    private Long instructorId;
}
