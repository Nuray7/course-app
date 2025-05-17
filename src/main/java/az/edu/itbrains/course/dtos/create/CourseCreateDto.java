package az.edu.itbrains.course.dtos.create;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class CourseCreateDto {

    private String title;

    private String description;

    private String category;

    private String imageUrl;

    private boolean isNew;

    private boolean isPopular;

    private int durationInHours;
}
