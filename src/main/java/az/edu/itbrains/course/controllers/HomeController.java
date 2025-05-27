package az.edu.itbrains.course.controllers;

import az.edu.itbrains.course.dtos.create.CourseCreateDto;
import az.edu.itbrains.course.services.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import az.edu.itbrains.course.services.CourseService;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }


    @GetMapping("/about")
    public String about() {
        return "about.html";
    }


    @GetMapping("/courses")
    public String courses() {
        return "courses.html";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact.html";

    }

    @GetMapping("/testimonial")
    public String testimonial() {
        return "testimonial.html";

    }

    @GetMapping("/team")
    public String team() {
        return "team.html";

    }

    @GetMapping("/detail")
    public String detail() {
        return "detail.html";

    }

    @GetMapping("/feature")
    public String feature() {
        return "feature.html";

    }
    





}
