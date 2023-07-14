package eu.mauizio90.RestBlog.services;

import eu.mauizio90.RestBlog.entities.Category;
import eu.mauizio90.RestBlog.repositories.CategoryRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mauiz
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    public List<Category> findAll() {
        return this.categoryRepo.findAll();
    }
    
    
    
}
