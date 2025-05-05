package az.edu.itbrains.course.controllers;


import az.edu.itbrains.course.dtos.auth.RegisterDto;
import az.edu.itbrains.course.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final CourseService courseService;



    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "auth/register";
    }

    @GetMapping("/forgot-password")
    public String forgot() {
        return "auth/forgot";
    }

    @GetMapping("/change-password")
    public String change() {
        return "auth/change";
    }
}
