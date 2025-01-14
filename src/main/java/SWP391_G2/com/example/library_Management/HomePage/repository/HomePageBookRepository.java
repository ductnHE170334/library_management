package SWP391_G2.com.example.library_Management.HomePage.repository;

import SWP391_G2.com.example.library_Management.Entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HomePageBookRepository extends JpaRepository<Book, Integer>{

    @Query("SELECT n FROM Book n WHERE n.name like %?1%")
    Page<Book> findBookByName(String name, Pageable pageable);

    @Query("SELECT b FROM Book b JOIN b.categories c WHERE c.id = ?1")
    Page<Book> findBooksByCategory(int categoryId, Pageable pageable);

    @Query("SELECT b FROM Book b JOIN b.authors a WHERE a.id = ?1")
    Page<Book> findBooksByAuthor(int authorId, Pageable pageable);
}
