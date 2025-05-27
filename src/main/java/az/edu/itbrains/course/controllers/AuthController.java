package az.edu.itbrains.course.controllers;


import az.edu.itbrains.course.dtos.auth.RegisterDto;
import az.edu.itbrains.course.services.UserService;
import az.edu.itbrains.course.services.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    private final CourseService courseService;



    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("registerDto", new RegisterDto());
        return "auth/register";  // burada .html silindi
    }

//    @PostMapping("/register")
//    public String register(@Valid RegisterDto registerDto,
//                           BindingResult bindingResult,
//                           Model model) {
//
//        if (bindingResult.hasErrors()) {
//            return "auth/register";
//        }
//
//        if (userService.existsByEmail(registerDto.getEmail())) {
//            model.addAttribute("emailError", "Bu email artıq qeydiyyatdan keçib.");
//            return "auth/register";
//        }
//
//        userService.registerUser(registerDto);
//
//        return "redirect:/login";
//    }


    @PostMapping("/register")
    public String register(@Valid  RegisterDto registerDto, BindingResult result){
        if (result.hasErrors()){
            return "/auth/register.html";
        }

        userService.registerUser(registerDto);
        return "redirect:/login";
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
