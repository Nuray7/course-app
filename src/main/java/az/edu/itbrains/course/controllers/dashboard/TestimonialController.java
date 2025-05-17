package az.edu.itbrains.course.controllers.dashboard;

import az.edu.itbrains.course.dtos.TestimonialCreateDto;
import az.edu.itbrains.course.dtos.TestimonialDto;
import az.edu.itbrains.course.services.TestimonialService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TestimonialController {

    private final TestimonialService testimonialService;
    private final ModelMapper modelMapper;

    public TestimonialController(TestimonialService testimonialService, ModelMapper modelMapper) {
        this.testimonialService = testimonialService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/testimonial")
    public String testimonials(Model model) {
        List<TestimonialDto> testimonials = testimonialService.getRecentTestimonials(PageRequest.of(0, 50));
        model.addAttribute("testimonials", testimonials); // <-- diqqət: cəmdə "testimonials"
        return "dashboard/testimonial/index";
    }


    @GetMapping("/testimonial/create")
    public String createTestimonialForm(Model model) {
        model.addAttribute("testimonial", new TestimonialCreateDto());
        return "dashboard/testimonial/create";
    }


    @PostMapping("/testimonial/create")
    public String createTestimonial(@ModelAttribute("testimonial") TestimonialCreateDto testimonialDto) {
        testimonialService.createTestimonial(testimonialDto);
        return "redirect:/admin/testimonial";
    }


    @PostMapping("/testimonial/delete/{id}")
    public String deleteTestimonial(@PathVariable Long id) {
        testimonialService.deleteTestimonial(id);
        return "redirect:/admin/testimonial";
    }
}
