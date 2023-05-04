package eu.mauizio90.RestBlog.repositories;

import eu.mauizio90.RestBlog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mauiz
 */
public interface PostRepo extends JpaRepository<Post, Long>{
    
}
