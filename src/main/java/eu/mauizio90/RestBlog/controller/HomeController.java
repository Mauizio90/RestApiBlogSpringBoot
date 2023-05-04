package eu.mauizio90.RestBlog.controller;

import eu.mauizio90.RestBlog.entities.Post;
import eu.mauizio90.RestBlog.services.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public ResponseEntity<List<Post>> Home() {
        List<Post> posts = postService.findAll();
        return ResponseEntity.ok(posts);
    }
}