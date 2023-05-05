package eu.mauizio90.RestBlog.controller;

import eu.mauizio90.RestBlog.entities.Comment;
import eu.mauizio90.RestBlog.entities.Post;
import eu.mauizio90.RestBlog.exceptions.PostNotFoundException;
import eu.mauizio90.RestBlog.services.CommentService;
import eu.mauizio90.RestBlog.services.PostService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author mauiz
 */
@RestController
public class CommentsController {
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private CommentService commentService;
    
    @GetMapping("/posts/{id}/comments")
    public Set<Comment> retrieveAllCommentsByPost(@PathVariable Long id){
        Optional<Post> post = postService.findById(id);
        
        if (post.isEmpty()){
            throw new PostNotFoundException("id:" + id);
        }else if(post.get().getComments().isEmpty()){
            throw new RuntimeException("Nessun Commento");
        }
        
        return post.get().getComments();
    }
    
    @PostMapping("/posts/{id}/comments")
    public ResponseEntity<Object> createCommentsByPost(@PathVariable Long id, @Valid @RequestBody Comment comment){
        Optional<Post> post = postService.findById(id);
        
        if (post.isEmpty()){
            throw new PostNotFoundException("id:" + id);
        }
        comment.setPost(post.get());
        Comment savedComment = commentService.addComment(comment);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedComment.getId())
                .toUri();
        
        return ResponseEntity.created(location).build();
    }

    
}
    