package by.bezushko.backendpractice.repository;

import by.bezushko.backendpractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User getUserByPassNumber(String passNumber);
}
