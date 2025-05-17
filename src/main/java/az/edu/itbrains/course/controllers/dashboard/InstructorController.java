package az.edu.itbrains.course.controllers.dashboard;

import az.edu.itbrains.course.dtos.create.InstructorCreateDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import az.edu.itbrains.course.dtos.InstructorDto;
import az.edu.itbrains.course.services.InstructorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class InstructorController {

    private final InstructorService instructorService;
    private final ModelMapper modelMapper;

    public InstructorController(InstructorService instructorService, ModelMapper modelMapper) {
        this.instructorService = instructorService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/instructor")
    public String instructors(Model model) {
        List<InstructorDto> instructors = instructorService.getAllInstructors();
        model.addAttribute("instructors", instructors);
        return "dashboard/instructor/index";
    }

    @GetMapping("/instructor/create")
    public String createInstructorForm(Model model) {
        model.addAttribute("instructor", new InstructorCreateDto());
        return "dashboard/instructor/create";
    }






}