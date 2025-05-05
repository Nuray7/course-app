package az.edu.itbrains.course.services.impls;

import az.edu.itbrains.course.dtos.InstructorCreateDto;
import az.edu.itbrains.course.dtos.InstructorDto;
import az.edu.itbrains.course.services.InstructorService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    @Override
    public List<InstructorDto> getLatestInstructors(Pageable pageable) {
        return List.of();
    }

    @Override
    public void createInstructor(InstructorCreateDto instructorDto, MultipartFile image) {

    }

    @Override
    public void deleteInstructor(Long id) {

    }
}
