package SWP391_G2.com.example.library_Management.Staff.Admin.repository;

import SWP391_G2.com.example.library_Management.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminAuthorRepository extends JpaRepository<Author, String> {
}