package az.edu.itbrains.course.services.impls;

import az.edu.itbrains.course.dtos.InstructorCreateDto;
import az.edu.itbrains.course.dtos.InstructorDto;
import az.edu.itbrains.course.models.Instructor;
import az.edu.itbrains.course.repositories.InstructorRepository;
import az.edu.itbrains.course.services.InstructorService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final ModelMapper modelMapper;
    private final Cloudinary cloudinary;

    @Override
    public List<InstructorDto> getAllInstructors() {
        return instructorRepository.findAll().stream()
                .map(instructor -> modelMapper.map(instructor, InstructorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public InstructorDto getInstructorById(Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Instructor not found with id: " + id));
        return modelMapper.map(instructor, InstructorDto.class);
    }

    @Override
    public void updateInstructor(InstructorDto instructorDto, MultipartFile image) {
//        Instructor instructor = instructorRepository.findById(instructorDto.getId())
//                .orElseThrow(() -> new IllegalArgumentException("Instructor not found with id: " + instructorDto.getId()));
//
//        instructor.setName(instructorDto.getName());
//        instructor.setBio(instructorDto.getBio());
//
//        if (image != null && !image.isEmpty()) {
//            validateImage(image);
//            try {
//                Map uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
//                instructor.setImageUrl((String) uploadResult.get("url"));
//            } catch (IOException e) {
//                throw new RuntimeException("Failed to upload image", e);
//            }
//        }
//
//        instructorRepository.save(instructor);
    }

    @Override
    public List<InstructorDto> getLatestInstructors(Pageable pageable) {
        return instructorRepository.findAll(pageable).stream()
                .map(instructor -> modelMapper.map(instructor, InstructorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createInstructor(InstructorCreateDto instructorCreateDto, MultipartFile image) {
        if (image == null || image.isEmpty()) {
            throw new IllegalArgumentException("Product image is required");
        }

        try {
            Map uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
            String photoUrl = (String) uploadResult.get("url");


            Instructor instructor = new Instructor();
            instructor.setName(instructorCreateDto.getName());
            instructor.setImageUrl(photoUrl);
            instructor.setBio(instructorCreateDto.getBio());


            instructorRepository.save(instructor);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image", e);
        }


    }

    @Override
    public void deleteInstructor(Long id) {
        if (!instructorRepository.existsById(id)) {
            throw new IllegalArgumentException("Instructor not found with id: " + id);
        }
        instructorRepository.deleteById(id);
    }

//    private void validateImage(MultipartFile image) {
//        if (!image.getContentType().startsWith("image/")) {
//            throw new IllegalArgumentException("Only image files are allowed");
//        }
    }
