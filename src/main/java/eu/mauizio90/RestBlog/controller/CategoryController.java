package eu.mauizio90.RestBlog.controller;

import eu.mauizio90.RestBlog.entities.Category;
import eu.mauizio90.RestBlog.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mauiz
 */
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    
    @GetMapping("")
    public ResponseEntity<List<Category>> retrieveAllCategories() {
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }
}
