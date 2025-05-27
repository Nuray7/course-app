package az.edu.itbrains.course.services

import az.edu.itbrains.course.dtos.CategoryCreateDto
import az.edu.itbrains.course.dtos.CategoryDto
import az.edu.itbrains.course.models.Category
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    void createCategory(@Valid CategoryCreateDto categoryCreateDto);
    Optional<Category> getCategoryById(Long id);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}


