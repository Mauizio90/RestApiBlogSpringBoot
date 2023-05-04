
package eu.mauizio90.RestBlog.configs;

import eu.mauizio90.RestBlog.entities.Comment;
import eu.mauizio90.RestBlog.entities.Post;
import eu.mauizio90.RestBlog.entities.Role;
import eu.mauizio90.RestBlog.entities.User;
import eu.mauizio90.RestBlog.services.CommentService;
import eu.mauizio90.RestBlog.services.PostService;
import eu.mauizio90.RestBlog.services.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author mauiz
 */
@Component
public class CMDLrunner implements CommandLineRunner{
    @Autowired
    UserService userService = new UserService();
    
    @Autowired
    PostService postService = new PostService();
    
    
    @Autowired
    CommentService commentService = new CommentService();
    
    @Override
    public void run(String... args) throws Exception {
        
        Role admin = new Role();
        Role user = new Role();
        admin.setName("Admin");
        user.setName("User");
        
        Set<Role> rolesAdmin = new HashSet<>();
        rolesAdmin.add(admin);
        rolesAdmin.add(user);
        
        Set<Role> rolesUser = new HashSet<>();
        rolesAdmin.add(user);
        
        User maurizio = new User("Maurizio", "Mauizio90", "Mauizio90@gmail.com", "maurizio", rolesAdmin);
        User peter = new User("Peter", "Spiderman", "Spidey@gmail.com", "ragnetto", rolesUser);
        User logan = new User("Logan", "Wolverine", "wolverine@gmail.com", "ghiro", rolesUser);
        
        Post post1maurizio = new Post("Titolone del postone", "Descrizione del Postone", "Contenuto del postone", maurizio);
        Post post2maurizio = new Post("Titolone del postone 2", "Descrizione del Postone 2", "Contenuto del postone 2", maurizio);
        
        Comment commento1 = new Comment(peter, "bello sto postone", post1maurizio);
        Comment commento2 = new Comment(logan, "bello sto postonissimo", post1maurizio);
        
        
        
        userService.addUser(maurizio);
        userService.addUser(peter);
        userService.addUser(logan);
        
        postService.addPost(post1maurizio);
        postService.addPost(post2maurizio);
        
        commentService.addComment(commento1);
        commentService.addComment(commento2);
    }
}
