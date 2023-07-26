
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
        
        Post post1maurizio = new Post("Le migliori novità nel mondo dei videogiochi", "Scopri le ultime novità nel mondo dei videogiochi, dalle console ai giochi per PC.", "Il mondo dei videogiochi è in costante evoluzione, con nuove tecnologie e giochi appassionanti che... (contenuto del post)", maurizio,"https://media.gqitalia.it/photos/64800e0d5dd81c9fc9cbdff7/16:9/w_2560%2Cc_limit/100-best-games-hp-b.jpg");
        post1maurizio.addCategory(category1);
        post1maurizio.setFeatured(true);
        Post post2maurizio = new Post("I film più attesi del 2023", "Preparati a un'emozionante stagione cinematografica con una selezione dei film più attesi dell'anno.", "L'anno 2023 promette di essere ricco di film spettacolari, dagli adattamenti dei fumetti... (contenuto del post)", maurizio,"https://image.cnbcfm.com/api/v1/image/104768589-movies-anywhere.JPG?v=1507816437&w=1920&h=1080");
        post2maurizio.addCategory(category2);
        Post post3maurizio = new Post("I fumetti più venduti del mese", "Scopri quali fumetti stanno dominando le classifiche di vendita questo mese.", "Il mercato dei fumetti è in fermento, con nuovi titoli e avventure mozzafiato che... (contenuto del post)", maurizio,"https://static.onecms.io/wp-content/uploads/sites/6/2021/05/07/May-Comics.jpg");
        post3maurizio.addCategory(category3);
        Post post4maurizio = new Post("Le tendenze musicali del 2023", "Esplora le tendenze musicali emergenti e le hit più ascoltate del momento.", "Il mondo della musica è un universo in continua espansione, con nuovi talenti pronti a... (contenuto del post)", maurizio,"https://www.incimages.com/uploaded_files/image/1920x1080/getty_626660256_2000108620009280158_388846.jpg");
        post4maurizio.addCategory(category4);
        Post post1peter = new Post("Le prossime avventure dell'Uomo Ragno", "Scopri cosa ci riserva il futuro per l'eroe amichevole di quartiere.", "Peter Parker si prepara a vivere nuove avventure come Spider-Man, affrontando nemici... (contenuto del post)", peter, "https://media-assets.wired.it/photos/62a6ede3caa182924b403d43/16:9/w_1280,c_limit/spider-man-no-way-home.jpg");
        post1peter.addCategory(category2);
        post1peter.setFeatured(true);
        Post post2peter = new Post("I gadget più innovativi di Spider-Man", "Esplora la vasta gamma di gadget utilizzati da Spider-Man nella sua lotta contro il crimine.", "Da ragnatele ad avanzate tecnologie, Spider-Man è noto per la sua vasta gamma di gadget... (contenuto del post)", peter, "https://sm.ign.com/t/ign_it/screenshot/default/sss_cuc6.1280.jpg");
        post2peter.addCategory(category1);
        Post post3peter = new Post("Le migliori battaglie di Spider-Man", "Rivivi alcuni dei momenti più epici delle battaglie di Spider-Man contro i suoi avversari.", "Spider-Man ha affrontato molti nemici nel corso degli anni, da scontri con supercriminali a... (contenuto del post)", peter, "https://fictionhorizon.com/wp-content/uploads/2021/08/Venom-vs-Spider-Man.jpg");
        post3peter.addCategory(category3);
        post3peter.setFeatured(true);
        Post post1logan = new Post("Le origini di Wolverine", "Scopri il passato misterioso e le origini dell'incredibile mutante noto come Wolverine.", "Logan Howlett, meglio conosciuto come Wolverine, ha una storia intricata e... (contenuto del post)", logan, "https://www.fumettologica.it/wp-content/uploads/2018/06/return-of-wolverine-01-2-670x350.jpg");
        post1logan.addCategory(category3);
        post1logan.setFeatured(true);
        Post post2logan = new Post("Le avventure solitarie di Wolverine", "Esplora le storie di Wolverine in cui l'eroe si impegna in missioni da solista.", "Oltre ad essere un membro degli X-Men, Wolverine ha avuto numerose avventure da... (contenuto del post)", logan, "https://movieplayer.net-cdn.it/t/images/2023/07/11/wolverine_97_jpg_1600x900_crop_q85.jpg");
        post2logan.addCategory(category2);
        Post post3logan = new Post("Le curiosità sul fumetto di Wolverine", "Scopri alcune curiosità e dietro le quinte sulle storie più famose di Wolverine a fumetti.", "Le avventure di Wolverine hanno catturato l'immaginazione dei lettori per decenni... (contenuto del post)", logan, "https://images.comicbooktreasury.com/wp-content/uploads/2022/05/Wolverine-Reading-Order-705x470.jpg");
        post3logan.addCategory(category3);

        
        Comment commento1 = new Comment(peter, "Bello questo articolo sui videogiochi!", post1maurizio);
        Comment commento2 = new Comment(logan, "Sono d'accordo, il mondo dei videogiochi è sempre pieno di sorprese.", post1maurizio);
        
        
        
        userService.addUser(maurizio);
        userService.addUser(peter);
        userService.addUser(logan);
        
        postService.addPost(post1maurizio);
        postService.addPost(post2maurizio);
        postService.addPost(post3maurizio);
        postService.addPost(post4maurizio);
        postService.addPost(post1peter);
        postService.addPost(post2peter);
        postService.addPost(post3peter);
        postService.addPost(post1logan);
        postService.addPost(post2logan);
        postService.addPost(post3logan);
        
        commentService.addComment(commento1);
        commentService.addComment(commento2);
        
    }
}
