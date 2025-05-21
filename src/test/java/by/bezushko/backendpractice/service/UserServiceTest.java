package by.bezushko.backendpractice.service;

import by.bezushko.backendpractice.dto.UserDto;
import by.bezushko.backendpractice.entity.User;
import by.bezushko.backendpractice.repository.UserRepository;
import by.bezushko.backendpractice.service.config.TestConfiguration;
import by.bezushko.backendpractice.service.factory.UserTestFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest extends TestConfiguration {
    private UserDto created;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
        created = UserTestFactory.createUserDto();
        userService.addUser(created);
    }

    @Test
    void testCreateUser () {
        assertThat(created).isNotNull();
        assertThat(created.passNumber()).isEqualTo("ABC123");
        User found = userRepository.getUserByPassNumber("ABC123");
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Иван");
    }

    @Test
    void testGetUserByPassNumber() {
        UserDto found = userService.getUserByPassNumber("ABC123");
        assertThat(found).isNotNull();
        assertThat(found.passNumber()).isEqualTo("ABC123");
    }

    @Test
    void testDeleteUser() {
        userService.deleteUser ("ABC123");
        User found = userRepository.getUserByPassNumber("ABC123");
        assertThat(found).isNull();
    }

    @Test
    void testUpdateUser() {
        UserDto updateDto = new UserDto(
                "Иван Updated",
                "Иванов",
                LocalDateTime.now(),
                "235dsg235",
                "12355552",
                "ABC123",
                "updated.ivanov@example.com",
                "newPassword456"
        );
        UserDto updated = userService.updateUser ("ABC123", updateDto);
        assertThat(updated).isNotNull();
        assertThat(updated.name()).isEqualTo("Иван Updated");
        assertThat(updated.login()).isEqualTo("updated.ivanov@example.com");

        User found = userRepository.getUserByPassNumber("ABC123");
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Иван Updated");
    }
}