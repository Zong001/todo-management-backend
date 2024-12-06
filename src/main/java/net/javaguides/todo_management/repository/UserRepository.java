package net.javaguides.todo_management.repository;

import net.javaguides.todo_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByEmail (String email);
    Optional<User> findByUserNameOrEmail(String username, String email);
}
