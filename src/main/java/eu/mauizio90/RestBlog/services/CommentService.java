package eu.mauizio90.RestBlog.services;

import eu.mauizio90.RestBlog.entities.Comment;
import eu.mauizio90.RestBlog.repositories.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mauiz
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;
    
    public Comment addComment(Comment comment) {
        return commentRepo.save(comment);
    }
    
}
