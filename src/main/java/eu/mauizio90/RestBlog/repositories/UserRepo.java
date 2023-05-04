package eu.mauizio90.RestBlog.repositories;

import eu.mauizio90.RestBlog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mauiz
 */
public interface UserRepo extends JpaRepository<User, Long>{
    
}
