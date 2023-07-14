
package eu.mauizio90.RestBlog.configs;

import eu.mauizio90.RestBlog.entities.Category;
import eu.mauizio90.RestBlog.entities.Comment;
import eu.mauizio90.RestBlog.entities.Post;
import eu.mauizio90.RestBlog.entities.Role;
import eu.mauizio90.RestBlog.entities.User;
import eu.mauizio90.RestBlog.services.CategoryService;
import eu.mauizio90.RestBlog.services.CommentService;
import eu.mauizio90.RestBlog.services.PostService;
import eu.mauizio90.RestBlog.services.RoleService;
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
    UserService userService;
    
    @Autowired
    PostService postService;
    
    @Autowired
    RoleService roleService;
    
    @Autowired
    CommentService commentService;
    
    @Autowired
    CategoryService categoryService;
    
    @Override
    public void run(String... args) throws Exception {
        
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");
        
        roleService.addRole(adminRole);
        roleService.addRole(userRole);
        
        Category category1 = new Category("Videogames");
        Category category2 = new Category("Movies");
        Category category3 = new Category("Comics");
        Category category4 = new Category("Music");
        
        categoryService.addCategory(category1);
        categoryService.addCategory(category2);
        categoryService.addCategory(category3);
        categoryService.addCategory(category4);
        
        
        
        User maurizio = new User("Maurizio", "Mauizio90", "Mauizio90@gmail.com", "maurizio");
        maurizio.addRole(roleService.findById(1L).get());
        User peter = new User("Peter", "Spiderman", "Spidey@gmail.com", "ragnetto");
        peter.addRole(roleService.findById(2L).get());
        User logan = new User("Logan", "Wolverine", "wolverine@gmail.com", "ghiro");
        logan.addRole(roleService.findById(2L).get());
        
        Post post1maurizio = new Post("Titolone del postone", "Descrizione del Postone", "Contenuto del postone", maurizio);
        post1maurizio.addCategory(category1);
        Post post2maurizio = new Post("Titolone del postone 2", "Descrizione del Postone 2", "Contenuto del postone 2", maurizio);
        post2maurizio.addCategory(category2);
        Post post3maurizio = new Post("Titolone del postone 3", "Descrizione del Postone 3", "Contenuto del postone 3", maurizio);
        post3maurizio.addCategory(category3);
        Post post4maurizio = new Post("Titolone del postone 4", "Descrizione del Postone 4", "Contenuto del postone 4", maurizio);
        post4maurizio.addCategory(category4);
        
        Comment commento1 = new Comment(peter, "bello sto postone", post1maurizio);
        Comment commento2 = new Comment(logan, "bello sto postonissimo", post1maurizio);
        
        
        
        userService.addUser(maurizio);
        userService.addUser(peter);
        userService.addUser(logan);
        
        postService.addPost(post1maurizio);
        postService.addPost(post2maurizio);
        postService.addPost(post3maurizio);
        postService.addPost(post4maurizio);
        
        commentService.addComment(commento1);
        commentService.addComment(commento2);
    }
}
