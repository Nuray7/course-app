package az.edu.itbrains.course.services.impls;


import az.edu.itbrains.course.dtos.CourseDto;
import az.edu.itbrains.course.dtos.create.CourseCreateDto;
import az.edu.itbrains.course.models.Course;
import az.edu.itbrains.course.repositories.CourseRepository;
import az.edu.itbrains.course.services.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private  final ModelMapper modelMapper;
    @Override
    public void createCourse(@Valid CourseCreateDto courseCreateDto, MultipartFile image) {
        Course course = new Course();
        course.setTitle(courseCreateDto.getTitle());
        course.setDescription(courseCreateDto.getDescription());
        course.setCategory(courseCreateDto.getCategory());
        course.setImageUrl(courseCreateDto.getImageUrl());
        course.setNew(courseCreateDto.isNew());
        course.setPopular(courseCreateDto.isPopular());


        courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        deleteCourse(id);
    }

    @Override
    public void deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Course with ID " + id + " not found");
        }
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return convertToDtoList(courseRepository.findAll());
    }

    @Override
    public List<CourseDto> getNewCourses(Pageable pageable) {
        List<Course> courses = courseRepository.findByIsNewTrue(pageable);
        return convertToDtoList(courses);
    }

    @Override
    public List<CourseDto> getPopularCourses(Pageable pageable) {
        return convertToDtoList(courseRepository.findByIsPopularTrue(pageable));
    }

    @Override
    public List<CourseDto> getCoursesByCategory(String category) {
        return convertToDtoList(courseRepository.findByCategoryIgnoreCase(category));
    }

    @Override
    public List<CourseDto> getCourses() {
        return convertToDtoList(courseRepository.findAll());
    }

    private List<CourseDto> convertToDtoList(List<Course> courses) {
        List<CourseDto> courseDtos = new ArrayList<>();
        for (Course course : courses) {
            CourseDto dto = new CourseDto();
            dto.setId(course.getId());
            dto.setTitle(course.getTitle());
            dto.setDescription(course.getDescription());
            dto.setCategory(course.getCategory());
            dto.setImageUrl(course.getImageUrl());
            dto.setNew(course.isNew());
            dto.setPopular(course.isPopular());
            dto.setInstructorName(course.getInstructor() != null ? course.getInstructor().getName() : "N/A");
            courseDtos.add(dto);
        }
        return courseDtos;
    }
}
