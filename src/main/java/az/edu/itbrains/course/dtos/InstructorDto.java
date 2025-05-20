package az.edu.itbrains.course.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDto {
    private Long id;
    private String name;
    private String bio;
    private String imageUrl;
}
