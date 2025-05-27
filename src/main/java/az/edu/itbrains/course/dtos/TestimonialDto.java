package az.edu.itbrains.course.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestimonialDto {
    private Long id;
    private String studentName;
    private String comment;
    private String courseTitle;
    private String imageUrl;
}
