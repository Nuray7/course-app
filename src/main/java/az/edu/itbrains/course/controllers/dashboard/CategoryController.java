package az.edu.itbrains.course.controllers.dashboard;


import az.edu.itbrains.course.dtos.CategoryCreateDto;
import az.edu.itbrains.course.dtos.CategoryDto;
import az.edu.itbrains.course.services.CategoryService;
import groovy.lang.Category;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public String index(Model model) {
        List<CategoryDto> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "dashboard/categories/index"; // <-- düzəldildi
    }

    @GetMapping("/categories/create")
    public String create(Model model) {
        model.addAttribute("category", new CategoryCreateDto());
        return "dashboard/categories/create"; // <-- düzəldildi
    }

    @PostMapping("/categories/create")
    public String create(@Valid CategoryCreateDto categoryCreateDto, BindingResult bindingResult, org.springframework.web.multipart.MultipartFile image){
        if(bindingResult.hasErrors()){
            return "/dashboard/categories/create";
        }
        categoryService.createCategory(categoryCreateDto);
        return "redirect:/admin/categories";
    }
//
//    @GetMapping("/categories/edit/{id}")
//    public String edit(@PathVariable Long id, Model model) {
//        Category category = categoryService.getCategoryById(id)
//                .orElseThrow(() -> new RuntimeException("Category not found"));
//        model.addAttribute("category", category);
//        return "dashboard/categories/update"; // <-- düzəldildi
//    }
//
//    @PostMapping("/categories/edit/{id}")
//    public String edit(@PathVariable Long id,
//                       @Valid @ModelAttribute("category") Category category,
//                       BindingResult result) {
//        if (result.hasErrors()) {
//            return "dashboard/categories/update"; // <-- düzəldildi
//        }
//        categoryService.updateCategory(id, category);
//        return "redirect:/admin/categories";
//    }

    @PostMapping("/categories/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/admin/categories";
    }
}
