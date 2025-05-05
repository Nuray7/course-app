package az.edu.itbrains.course.dtos;


import jakarta.validation.constraints.NotBlank;

public class InstructorCreateDto {
    @NotBlank
    private String name;

    private String bio;
    private String imageUrl;
}
