package az.edu.itbrains.course.services;


import az.edu.itbrains.course.dtos.create.CourseCreateDto;
import az.edu.itbrains.course.dtos.CourseDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CourseService {
    void createCourse(@Valid CourseCreateDto courseCreateDto, MultipartFile image);

    void delete(Long id);

    void deleteCourse(Long id);

    List<CourseDto> getAllCourses();

    List<CourseDto> getNewCourses(Pageable pageable);

    List<CourseDto> getPopularCourses(Pageable pageable);

    List<CourseDto> getCoursesByCategory(String category);

    List<CourseDto> getCourses();
}
