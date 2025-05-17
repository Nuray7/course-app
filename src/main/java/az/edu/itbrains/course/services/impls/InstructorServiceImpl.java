package az.edu.itbrains.course.services.impls;

import az.edu.itbrains.course.dtos.InstructorCreateDto;
import az.edu.itbrains.course.dtos.InstructorDto;
import az.edu.itbrains.course.models.Instructor;
import az.edu.itbrains.course.repositories.InstructorRepository;
import az.edu.itbrains.course.services.InstructorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<InstructorDto> getAllInstructors() {
        return List.of();
    }

    @Override
    public InstructorDto getInstructorById(Long id) {
        return null;
    }



    @Override
    public void updateInstructor(Long id, InstructorDto instructorDto) {

    }

    @Override
    public List<InstructorDto> getLatestInstructors(Pageable pageable) {
        return List.of();
    }

    @Override
    public void createInstructor(InstructorCreateDto instructorDto, MultipartFile image) {
        Instructor instructor = new Instructor();
        instructor.setName(instructorDto.getName());

        instructorRepository.save(instructor);
    }



    @Override
    public void deleteInstructor(Long id) {

    }

//    @Override
//    public List<InstructorDto> getAllInstructors() {
//        return convertToDtoList(instructorRepository.findAll());
//    }
//
//    @Override
//    public InstructorDto getInstructorById(Long id) {
//        Instructor instructor = instructorRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Instructor with ID " + id + " not found"));
//        return modelMapper.map(instructor, InstructorDto.class);
//    }
//
//    @Override
//    public void createInstructor(InstructorDto instructorDto) {
//        Instructor instructor = modelMapper.map(instructorDto, Instructor.class);
//        instructorRepository.save(instructor);
//    }
//
//    @Override
//    public void updateInstructor(Long id, InstructorDto instructorDto) {
//        Instructor instructor = instructorRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Instructor with ID " + id + " not found"));
//        instructor.setName(instructorDto.getName());
//        instructor.setBio(instructorDto.getBio());
//        instructor.setImageUrl(instructorDto.getImageUrl());
//        instructorRepository.save(instructor);
//    }
//
//    @Override
//    public List<InstructorDto> getLatestInstructors(Pageable pageable) {
//        List<Instructor> instructors = instructorRepository.findAll(pageable).getContent();
//        return convertToDtoList(instructors);
//    }
//
//    @Override
//    public void createInstructor(InstructorCreateDto instructorCreateDto, MultipartFile image) {
//        Instructor instructor = new Instructor();
//        instructor.setName(instructorCreateDto.getName());
//        instructor.setBio(instructorCreateDto.getBio());
//        instructor.setImageUrl(instructorCreateDto.getImageUrl());
//        // handle image file (e.g. save it to disk or cloud)
//        instructorRepository.save(instructor);
//    }
//
//    @Override
//    public void deleteInstructor(Long id) {
//        if (instructorRepository.existsById(id)) {
//            instructorRepository.deleteById(id);
//        } else {
//            throw new IllegalArgumentException("Instructor with ID " + id + " not found");
//        }
//    }
//
//    private List<InstructorDto> convertToDtoList(List<Instructor> instructors) {
//        List<InstructorDto> instructorDtos = new ArrayList<>();
//        for (Instructor instructor : instructors) {
//            InstructorDto dto = new InstructorDto();
//            dto.setId(instructor.getId());
//            dto.setName(instructor.getName());
//            dto.setBio(instructor.getBio());
//            dto.setImageUrl(instructor.getImageUrl());
//            instructorDtos.add(dto);
//        }
//        return instructorDtos;
//    }
}
