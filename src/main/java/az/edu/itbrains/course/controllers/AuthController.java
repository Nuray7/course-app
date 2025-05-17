package az.edu.itbrains.course.controllers;


import az.edu.itbrains.course.dtos.auth.RegisterDto;
import az.edu.itbrains.course.services.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final CourseService courseService;



    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("registerDto", new RegisterDto());
        return "auth/register.html";
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
