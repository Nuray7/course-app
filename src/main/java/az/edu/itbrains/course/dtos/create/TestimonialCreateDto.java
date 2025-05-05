package az.edu.itbrains.course.dtos.create;


import jakarta.validation.constraints.NotBlank;

public class TestimonialCreateDto {
    @NotBlank
    private String studentName;

    private String content;
}