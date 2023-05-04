package eu.mauizio90.RestBlog.services;

import eu.mauizio90.RestBlog.entities.Role;
import eu.mauizio90.RestBlog.repositories.RoleRepo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mauiz
 */
@Service
public class RoleService {
    
    @Autowired
    private RoleRepo roleRepo;
    
    public Role addRole(Role role){
        return roleRepo.save(role);
    }
    
    public Optional<Role> findById(Long id) {
        return roleRepo.findById(id);
    }
}
