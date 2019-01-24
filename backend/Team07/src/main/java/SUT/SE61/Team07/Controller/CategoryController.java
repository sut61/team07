package SUT.SE61.Team07.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Repository.*;
import SUT.SE61.Team07.Entity.*;


@RestController
class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/Stroage-Category")
    public Collection<Category> types() {
        return categoryRepository.findAll().stream().collect(Collectors.toList());
    }
}


