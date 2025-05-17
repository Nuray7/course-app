package az.edu.itbrains.course.services;

import az.edu.itbrains.course.dtos.InstructorCreateDto;
import az.edu.itbrains.course.dtos.InstructorDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InstructorService {
    List<InstructorDto> getAllInstructors();

    InstructorDto getInstructorById(Long id);



    void updateInstructor(Long id, InstructorDto instructorDto);

    List<InstructorDto> getLatestInstructors(Pageable pageable);

    void createInstructor(InstructorCreateDto instructorDto, MultipartFile image);

    void deleteInstructor(Long id);
}
