package az.edu.itbrains.course.repositories;

import az.edu.itbrains.course.models.Testimonial;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {

    @Query("SELECT t FROM Testimonial t ORDER BY t.id DESC")
    List<Testimonial> getRecentTestimonials(Pageable pageable);
}

