package eu.mauizio90.RestBlog.controller;

import eu.mauizio90.RestBlog.entities.User;
import eu.mauizio90.RestBlog.entities.UserDTO;
import eu.mauizio90.RestBlog.exceptions.UserNotFoundException;
import eu.mauizio90.RestBlog.services.UserService;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mauiz
 */
@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserResource {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("")
    public List<UserDTO> retrieveAllUsers(){
        return userService.findAll();
    }
    
    
    
    @GetMapping("/{id}")
    public Optional<UserDTO> retrieveUser(@PathVariable Long id){
        Optional<UserDTO> user = userService.findByIdDto(id);
        
        if(user.isEmpty()){
            throw  new UserNotFoundException("id:"+id);
                    }
        
        return user;
        
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        
        User saveduser = userService.addUser(user);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveduser.getId())
                .toUri();
        
        return ResponseEntity.created(location).build();
        
    }
}
