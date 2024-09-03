package net.parkguide.pgw.repository;
import net.parkguide.pgw.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
    Optional<User> findByUserEmail(String userEmail);
}
