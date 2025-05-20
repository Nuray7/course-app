package az.edu.itbrains.course.controllers.dashboard;

import az.edu.itbrains.course.dtos.InstructorCreateDto;
import az.edu.itbrains.course.dtos.InstructorDto;
import az.edu.itbrains.course.dtos.create.CourseCreateDto;
import az.edu.itbrains.course.services.InstructorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;
    private final ModelMapper modelMapper;

    @GetMapping("/instructor")
    public String instructors(Model model) {
        List<InstructorDto> instructors = instructorService.getAllInstructors();
        model.addAttribute("instructors", instructors);
        return "dashboard/instructor/index";
    }

    @GetMapping("/instructor/create")
    public String createInstructor(Model model) {
        model.addAttribute("instructor", new InstructorCreateDto());
        return "dashboard/instructor/create";
    }

    @PostMapping("/instructor/create")
    public String createIn(@Valid InstructorCreateDto instructorCreateDto, BindingResult bindingResult, MultipartFile image) {
        if(bindingResult.hasErrors()){
            return "/dashboard/instructor/create";
        }
        instructorService.createInstructor(instructorCreateDto , image);
        return "redirect:/admin/instructor";

    }

    @GetMapping("/instructor/edit/{id}")
    public String editInstructorForm(@PathVariable Long id, Model model) {
        InstructorDto instructor = instructorService.getInstructorById(id);
        model.addAttribute("instructor", instructor);
        return "dashboard/instructor/update";
    }

    @PostMapping("/instructor/update")
    public String updateInstructor(@Valid @ModelAttribute("instructor") InstructorDto instructorDto,
                                   BindingResult bindingResult,
                                   @RequestParam("image") MultipartFile image,
                                   RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "dashboard/instructor/update";
        }

        try {
            instructorService.updateInstructor(instructorDto, image);
            redirectAttributes.addFlashAttribute("success", "Instructor updated successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating instructor: " + e.getMessage());
        }
        return "redirect:/admin/instructor";
    }

    @PostMapping("/instructor/delete/{id}")
    public String deleteInstructor(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            instructorService.deleteInstructor(id);
            redirectAttributes.addFlashAttribute("success", "Instructor deleted successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error deleting instructor: " + e.getMessage());
        }
        return "redirect:/admin/instructor";
    }
}