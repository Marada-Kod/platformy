package edu.uph.ii.lab1.repository;


import edu.uph.ii.lab1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username=:usernameOrEmail OR u.email=:usernameOrEmail")
    User findByUsernameOrEmail(String usernameOrEmail);
}
