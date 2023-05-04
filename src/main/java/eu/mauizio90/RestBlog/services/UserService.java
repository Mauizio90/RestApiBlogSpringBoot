package eu.mauizio90.RestBlog.services;

import eu.mauizio90.RestBlog.entities.User;
import eu.mauizio90.RestBlog.repositories.UserRepo;
import java.util.List;
import java.util.Optional;
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
    
    public User addUser(User user){
       return userRepo.save(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    public void deleteById(Long id){
        userRepo.deleteById(id);
    }    
}
