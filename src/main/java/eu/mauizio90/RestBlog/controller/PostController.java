package eu.mauizio90.RestBlog.controller;

import eu.mauizio90.RestBlog.entities.Category;
import eu.mauizio90.RestBlog.entities.Post;
import eu.mauizio90.RestBlog.entities.User;
import eu.mauizio90.RestBlog.exceptions.UserNotFoundException;
import eu.mauizio90.RestBlog.services.CategoryService;
import eu.mauizio90.RestBlog.services.PostService;
import eu.mauizio90.RestBlog.services.UserService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author mauiz
 */
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/posts")
public class PostController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private PostService postService;
    
    @GetMapping("")
    public ResponseEntity<List<Post>> retrieveAll() {
        List<Post> posts = postService.findAll();
        return ResponseEntity.ok(posts);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> retrievePostById(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        return ResponseEntity.ok(post);
    }
    
    @GetMapping("/users/{id}")
    public List<Post> retrieveAllPostsByUser(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        
        if (user.isEmpty()){
            throw new UserNotFoundException("id:" + id);
        }else if(user.get().getPosts().isEmpty()){
            throw new RuntimeException("Nessun Post");
        }
        
        return user.get().getPosts();
    }
    
    @PostMapping("/users/{id}/create")
    public ResponseEntity<Object> createPostsByUser(@PathVariable Long id, @Valid @RequestBody Post post){
        Optional<User> user = userService.findById(id);
        
        if (user.isEmpty()){
            throw new UserNotFoundException("id:" + id);
        }
        post.setUser(user.get());
        Post savedPost = postService.addPost(post);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        
        return ResponseEntity.created(location).build();
    }
    
    
    
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<Set<Post>> retrieveAllbyCategories(@PathVariable Long categoryId) {
        Set<Post> posts = postService.findAllPostsByCategory(categoryId);
        return ResponseEntity.ok(posts);
    }
}
