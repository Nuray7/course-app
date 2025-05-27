package az.edu.itbrains.course.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestimonialCreateDto {
    @NotBlank
    private String studentName;

    @NotBlank
    private String comment;  // "content" -> "comment" kimi olmalıdır, çünki modeldə comment var

    private String courseTitle;

    private MultipartFile image;  // Şəkil yükləmək üçün əlavə olundu
}
