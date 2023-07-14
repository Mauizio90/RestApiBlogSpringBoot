package eu.mauizio90.RestBlog.services;

import eu.mauizio90.RestBlog.entities.Post;
import eu.mauizio90.RestBlog.repositories.CategoryRepo;
import eu.mauizio90.RestBlog.repositories.PostRepo;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mauiz
 */
@Service
public class PostService {
    
    @Autowired
    private PostRepo postRepo;
    
    @Autowired
    private CategoryRepo categoryRepo;
    
    public Post addPost(Post post){
       return postRepo.save(post);
    }

    public List<Post> findAll() {
        return postRepo.findAll();
    }

    public Optional<Post> findById(Long id) {
        return postRepo.findById(id);
    }
    
    public Set<Post> findAllPostsByCategory(Long categoryId) {
        return categoryRepo.findAllPostsByCategoryId(categoryId);
    }
}
