package az.edu.itbrains.course.controllers.dashboard;


import az.edu.itbrains.course.dtos.CourseDto;
import az.edu.itbrains.course.dtos.create.CourseCreateDto;
import az.edu.itbrains.course.services.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CourseController {

    private final CourseService courseService;
    private final ModelMapper modelMapper;

    public CourseController(CourseService courseService, ModelMapper modelMapper) {
        this.courseService = courseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/courses")
    public String courses(Model model) {
        List<CourseDto> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "dashboard/courses/index";
    }

    @GetMapping("/courses/create")
    public String createCourseForm(Model model) {
        model.addAttribute("course", new CourseCreateDto());
        return "dashboard/courses/create";
    }

    @PostMapping("/courses/create")
    public String createCourse(@ModelAttribute("course") CourseCreateDto courseCreateDto,
                               @RequestParam("imageFile") MultipartFile imageFile) {
        courseService.createCourse(courseCreateDto, imageFile);
        return "redirect:/admin/courses";

    }
}