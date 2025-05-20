package az.edu.itbrains.course.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "index.html";
    }


    @GetMapping("/about")
    public String about(){
        return "about.html";
    }


    @GetMapping("/courses")
    public String courses(){
        return "courses.html";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact.html";

    }
    @GetMapping("/testimonial")
    public String testimonial(){
        return "testimonial.html";

    }
    @GetMapping("/team")
    public String team(){
        return "team.html";

    }
    @GetMapping("/detail")
    public String detail(){
        return "detail.html";

    }
    @GetMapping("/feature")
    public String feature(){
        return "feature.html";

    }


}
