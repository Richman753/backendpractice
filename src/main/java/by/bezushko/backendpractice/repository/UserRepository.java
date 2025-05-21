package by.bezushko.backendpractice.repository;

import by.bezushko.backendpractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByPassNumber(String passNumber);
}
