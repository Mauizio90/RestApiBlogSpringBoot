package eu.mauizio90.RestBlog.services;

import eu.mauizio90.RestBlog.entities.Post;
import eu.mauizio90.RestBlog.repositories.PostRepo;
import java.util.List;
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
    
    public Post addPost(Post post){
       return postRepo.save(post);
    }

    public List<Post> findAll() {
        return postRepo.findAll();
    }
}
