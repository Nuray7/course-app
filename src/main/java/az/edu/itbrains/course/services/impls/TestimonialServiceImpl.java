package az.edu.itbrains.course.services.impls;

import az.edu.itbrains.course.dtos.TestimonialCreateDto;
import az.edu.itbrains.course.dtos.TestimonialDto;
import az.edu.itbrains.course.models.Testimonial;
import az.edu.itbrains.course.repositories.TestimonialRepository;
import az.edu.itbrains.course.services.TestimonialService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    private final TestimonialRepository testimonialRepository;
    private final Cloudinary cloudinary;
    private final ModelMapper modelMapper;

    public TestimonialServiceImpl(TestimonialRepository testimonialRepository,
                                  Cloudinary cloudinary,
                                  ModelMapper modelMapper) {
        this.testimonialRepository = testimonialRepository;
        this.cloudinary = cloudinary;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TestimonialDto> getRecentTestimonials(Pageable pageable) {
        List<Testimonial> testimonials = testimonialRepository.getRecentTestimonials(pageable);
        return testimonials.stream()
                .map(t -> modelMapper.map(t, TestimonialDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createTestimonial(TestimonialCreateDto dto) {
        try {
            MultipartFile imageFile = dto.getImage();
            String imageUrl = null;
            if (imageFile != null && !imageFile.isEmpty()) {
                Map<?, ?> uploadResult = cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
                imageUrl = (String) uploadResult.get("secure_url");
            }

            Testimonial testimonial = new Testimonial();
            testimonial.setStudentName(dto.getStudentName());
            testimonial.setComment(dto.getComment());
            testimonial.setCourseTitle(dto.getCourseTitle());
            testimonial.setImageUrl(imageUrl);

            testimonialRepository.save(testimonial);
        } catch (IOException e) {
            throw new RuntimeException("Could not upload image", e);
        }
    }

    @Override
    public void update(TestimonialDto testimonialDto) {

    }

    @Override
    public void deleteTestimonial(Long id) {
        testimonialRepository.deleteById(id);
    }

    @Override
    public TestimonialDto getById(Long id) {
        return null;
    }
}
