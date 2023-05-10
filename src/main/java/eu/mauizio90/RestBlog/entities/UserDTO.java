package eu.mauizio90.RestBlog.entities;

import java.util.List;

/**
 *
 * @author mauiz
 */
public record UserDTO (
        
        Long id,
        String name,
        String username,
        String email,
        List<Post> posts
){
    
}
