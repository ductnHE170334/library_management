package SWP391_G2.com.example.library_Management.Staff.Librarian.repository;

import SWP391_G2.com.example.library_Management.Entity.Book_item;
import SWP391_G2.com.example.library_Management.Entity.Borrow_index;
import SWP391_G2.com.example.library_Management.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibrarianBorrowIndexRepository extends JpaRepository<Borrow_index,Long> {
    Page<Borrow_index> findAll(Pageable pageable);

    List<Borrow_index> findByCustomer(User customer);
}
