package SUT.SE61.Team07.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
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
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/Category-insert/{id}/categoryname/{categoryname}")
     public ResponseEntity<Map<String, Object>> Categorysumbit(@PathVariable("id") Long id,
            @PathVariable("categoryname") String categoryname) {
                try{
                    Category c = new Category(categoryname);
                    this.categoryRepository.save(c);
                    Map<String, Object> json = new HashMap<String, Object>();
                    json.put("success", true);
                    json.put("status", "save");
        
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Content-Type", "application/json; charset=UTF-8");
                    headers.add("X-Fsl-Location", "/");
                    headers.add("X-Fsl-Response-Code", "302");
                    return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
                }catch (NullPointerException e) {
                    Map<String, Object> json = new HashMap<String, Object>();
                    System.out.println("Error Save CancelReservation");
                    json.put("success", false);
                    json.put("status", "save-false");
        
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Content-Type", "application/json; charset=UTF-8");
                    headers.add("X-Fsl-Location", "/");
                    headers.add("X-Fsl-Response-Code", "500");
                    return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.INTERNAL_SERVER_ERROR));
        
                }
    }
}


