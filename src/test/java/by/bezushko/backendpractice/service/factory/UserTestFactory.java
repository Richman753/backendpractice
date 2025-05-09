package by.bezushko.backendpractice.service.factory;

import by.bezushko.backendpractice.dto.UserDto;

import java.time.LocalDateTime;

public class UserTestFactory {
    public static UserDto createUserDto() {
        return new UserDto(
                "Иван",
                "Иванов",
                LocalDateTime.now(),
                "235dsg235",
                "12355552",
                "ABC123",
                "ivan.ivanov@example.com",
                "securePassword123"
        );
    }

}
