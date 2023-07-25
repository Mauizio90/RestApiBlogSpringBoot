
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
        
        Category category1 = new Category("Videogames","Esplora il vasto mondo dei videogiochi con recensioni, anteprime e approfondimenti su ultime uscite, classici e novità del settore gaming.");
        Category category2 = new Category("Movies","Dal grande schermo alle produzioni indipendenti, scopri le ultime notizie, recensioni e curiosità sulle pellicole più attese e apprezzate del momento.");
        Category category3 = new Category("Comics","Addentratevi nel magico universo dei fumetti, con recensioni e approfondimenti su graphic novel, supereroi, manga e fumetti d'autore.");
        Category category4 = new Category("Music","Dai grandi artisti alle nuove promesse, immergiti in un mix di generi musicali con recensioni di album, concerti e notizie sulle tendenze musicali del momento.");
        
        categoryService.addCategory(category1);
        categoryService.addCategory(category2);
        categoryService.addCategory(category3);
        categoryService.addCategory(category4);
        
        
        
        User maurizio = userService.createUser("Maurizio", "Mauizio90", "Mauizio90@gmail.com", "maurizio");
        maurizio.addRole(roleService.findById(1L).get());
        User peter = userService.createUser("Peter", "Spiderman", "Spidey@gmail.com", "ragnetto");
        User logan = userService.createUser("Logan", "Wolverine", "wolverine@gmail.com", "ghiro");
        
        Post post1maurizio = new Post("Titolone del postone", "Descrizione del Postone", "Contenuto del postone", maurizio,"https://media.gqitalia.it/photos/64800e0d5dd81c9fc9cbdff7/16:9/w_2560%2Cc_limit/100-best-games-hp-b.jpg");
        post1maurizio.addCategory(category1);
        Post post2maurizio = new Post("Titolone del postone 2", "Descrizione del Postone 2", "Contenuto del postone 2", maurizio,"https://image.cnbcfm.com/api/v1/image/104768589-movies-anywhere.JPG?v=1507816437&w=1920&h=1080");
        post2maurizio.addCategory(category2);
        Post post3maurizio = new Post("Titolone del postone 3", "Descrizione del Postone 3", "Contenuto del postone 3", maurizio,"https://static.onecms.io/wp-content/uploads/sites/6/2021/05/07/May-Comics.jpg");
        post3maurizio.addCategory(category3);
        Post post4maurizio = new Post("Titolone del postone 4", "Descrizione del Postone 4", "Contenuto del postone 4", maurizio,"https://www.incimages.com/uploaded_files/image/1920x1080/getty_626660256_2000108620009280158_388846.jpg");
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
