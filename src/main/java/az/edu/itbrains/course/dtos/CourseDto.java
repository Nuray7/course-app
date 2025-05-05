package az.edu.itbrains.course.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {

    private Long id;

    private String title;

    private String description;

    private String category;

    private String imageUrl;

    private boolean isNew;

    private boolean isPopular;

    private int durationInHours;

    private String instructorName;
}
