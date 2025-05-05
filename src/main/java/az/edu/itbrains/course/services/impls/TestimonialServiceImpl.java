package az.edu.itbrains.course.services.impls;

import az.edu.itbrains.course.dtos.TestimonialCreateDto;
import az.edu.itbrains.course.dtos.TestimonialDto;
import az.edu.itbrains.course.services.TestimonialService;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class TestimonialServiceImpl implements TestimonialService {
    @Override
    public List<TestimonialDto> getRecentTestimonials(Pageable pageable) {
        return List.of();
    }

    @Override
    public void createTestimonial(TestimonialCreateDto testimonialDto) {

    }

    @Override
    public void deleteTestimonial(Long id) {

    }
}
