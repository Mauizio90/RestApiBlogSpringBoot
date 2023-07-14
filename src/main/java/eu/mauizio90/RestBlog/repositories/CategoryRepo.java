package eu.mauizio90.RestBlog.repositories;

import eu.mauizio90.RestBlog.entities.Category;
import eu.mauizio90.RestBlog.entities.Post;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author mauiz
 */
public interface CategoryRepo extends JpaRepository<Category, Long> {
    @Query("SELECT c.posts FROM Category c WHERE c.id = :categoryId")
    Set<Post> findAllPostsByCategoryId(@Param("categoryId") Long categoryId);
}
