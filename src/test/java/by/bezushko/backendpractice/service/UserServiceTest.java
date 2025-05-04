package by.bezushko.backendpractice.service;

import by.bezushko.backendpractice.entity.User;
import by.bezushko.backendpractice.repository.UserRepository;
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
@Testcontainers
@ActiveProfiles("test")
class UserServiceTest {

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:latest")
                    .withDatabaseName("testdb")
                    .withUsername("testuser")
                    .withPassword("testpass");

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "update");
    }

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void testCreateUser () {
        User user = new User();
        user.setPassNumber("ABC123");
        user.setName("Иван");
        user.setSurname("Иванов");
        user.setLogin("ivan.ivanov@example.com");
        user.setPassword("securePassword123");
        user.setSnils("12355552");
        user.setInn("235dsg235");
        user.setBirthDate(LocalDateTime.now());

        User created = userService.createUser(user);

        assertThat(created).isNotNull();
        assertThat(created.getPassNumber()).isEqualTo("ABC123");

        User found = userRepository.getUserByPassNumber("ABC123");
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Иван");
    }

    @Test
    void testUpdateUser () {
        User user = new User();
        user.setPassNumber("DEF456");
        user.setName("Пётр");
        user.setSurname("Петров");
        user.setLogin("ivan.ivanov@example.com");
        user.setPassword("securePassword123");
        user.setSnils("12355552");
        user.setInn("235dsg235");
        user.setBirthDate(LocalDateTime.now());

        userService.createUser(user);

        User updatedData = new User();
        updatedData.setName("Алексей");
        updatedData.setSurname("Сидоров");
        User updatedUser  = userService.updateUser("DEF456", updatedData);

        assertThat(updatedUser).isNotNull();
        assertThat(updatedUser.getPassNumber()).isEqualTo("DEF456");
        assertThat(updatedUser.getName()).isEqualTo("Алексей");
        assertThat(updatedUser.getSurname()).isEqualTo("Сидоров");
    }

    @Test
    void testDeleteUser () {
        User user = new User();
        user.setPassNumber("GHI789");
        user.setName("Сергей");
        user.setSurname("Сергеев");
        user.setLogin("ivan.ivanov@example.com");
        user.setPassword("securePassword123");
        user.setSnils("12355552");
        user.setInn("235dsg235");
        user.setBirthDate(LocalDateTime.now());

        userService.createUser(user);

        User deleted = userService.deleteUser ("GHI789");
        assertThat(deleted).isNotNull();
        assertThat(deleted.getPassNumber()).isEqualTo("GHI789");
        User found = userRepository.getUserByPassNumber("GHI789");
        assertThat(found).isNull();
    }
}