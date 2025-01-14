package SWP391_G2.com.example.library_Management.Customer.repository;
import SWP391_G2.com.example.library_Management.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmailAndPassword(String email, String password);

    // Update the return type to User
    User findByEmail(String email);
}
