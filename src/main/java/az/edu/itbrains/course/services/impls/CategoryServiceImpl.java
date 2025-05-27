package az.edu.itbrains.course.services.impls;



import az.edu.itbrains.course.dtos.CategoryCreateDto;
import az.edu.itbrains.course.dtos.CategoryDto;
import az.edu.itbrains.course.models.Category;
import az.edu.itbrains.course.repositories.CategoryRepository;
import az.edu.itbrains.course.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> findCategories = categoryRepository.findAll().stream().collect(Collectors.toList());
        List<CategoryDto> categories = findCategories.stream().map(category -> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());

        return categories;
    }

    @Override
    public void createCategory(CategoryCreateDto categoryCreateDto) {
        Category category = new Category();
        category.setName(categoryCreateDto.getName());
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        return categoryRepository.findById(id).map(cat -> {
            cat.setName(category.getName());
            return categoryRepository.save(cat);
        }).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("category with ID " + id + " not found");
        }
    }
}



