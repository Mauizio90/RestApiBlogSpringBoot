package eu.mauizio90.RestBlog.repositories;

import eu.mauizio90.RestBlog.entities.Post;
import eu.mauizio90.RestBlog.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mauiz
 */
public interface RoleRepo extends JpaRepository<Role, Long>{
    
}
