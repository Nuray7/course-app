package az.edu.itbrains.course.services;


import az.edu.itbrains.course.dtos.TestimonialCreateDto;
import az.edu.itbrains.course.dtos.TestimonialDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TestimonialService {
    List<TestimonialDto> getRecentTestimonials(Pageable pageable);

    void createTestimonial(TestimonialCreateDto testimonialDto);

    void deleteTestimonial(Long id);
}

