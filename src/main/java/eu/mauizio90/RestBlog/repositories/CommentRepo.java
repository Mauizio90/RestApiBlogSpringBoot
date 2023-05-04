package eu.mauizio90.RestBlog.repositories;

import eu.mauizio90.RestBlog.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mauiz
 */
public interface CommentRepo extends JpaRepository<Comment, Long>{
    
}
