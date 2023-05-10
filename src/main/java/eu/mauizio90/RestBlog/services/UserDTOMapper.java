package eu.mauizio90.RestBlog.services;

import eu.mauizio90.RestBlog.entities.User;
import eu.mauizio90.RestBlog.entities.UserDTO;
import java.util.function.Function;
import org.springframework.stereotype.Service;

/**
 *
 * @author mauiz
 */
@Service
public class UserDTOMapper implements Function<User, UserDTO> {

    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                        user.getId(),
                        user.getName(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getPosts());
    }
    
}
