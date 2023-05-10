package eu.mauizio90.RestBlog.services;

import eu.mauizio90.RestBlog.entities.User;
import eu.mauizio90.RestBlog.entities.UserDTO;
import eu.mauizio90.RestBlog.repositories.UserRepo;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mauiz
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private UserDTOMapper userDTOMapper;
    
    public User addUser(User user){
       return userRepo.save(user);
    }

    public List<UserDTO> findAll() {
        return userRepo.findAll()
                .stream()
                .map(userDTOMapper).collect(Collectors.toList());
    }

    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }
    
    public Optional<UserDTO> findByIdDto(Long id) {
        return userRepo.findById(id)
                .map(userDTOMapper);
    }

    public void deleteById(Long id){
        userRepo.deleteById(id);
    }    
}
