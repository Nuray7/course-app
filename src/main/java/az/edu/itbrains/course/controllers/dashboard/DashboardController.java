package az.edu.itbrains.course.controllers.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/admin")
    public String admin() {

        return "dashboard/index.html";
    }



//    @GetMapping("/dashboard/category")
//    public String categoryPage() {
//        return "category";
//    }
//
//    @GetMapping("/dashboard/product")
//    public String productPage() {
//        return "product";
//    }
//
//    @GetMapping("/dashboard/user")
//    public String userPage() {
//        return "user";
//    }
//
//    @GetMapping("/dashboard/role")
//    public String rolePage() {
//        return "role";
//    }
//
//    @GetMapping("/dashboard/contact")
//    public String contactPage() {
//        return "contact";
//    }
//
//    @GetMapping("/dashboard/testimonial")
//    public String testimonialPage() {
//        return "testimonial";
//    }
//
//    @GetMapping("/dashboard/instructor")
//    public String instructorPage() {
//        return "instructor";
//    }
}


