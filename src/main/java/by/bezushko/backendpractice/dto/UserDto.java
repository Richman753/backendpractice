package by.bezushko.backendpractice.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record UserDto (
        @NotBlank(message = "Имя обязательно для заполнения")
        String name,

        @NotBlank(message = "Фамилия обязательна для заполнения")
        String surname,

        @NotNull(message = "Дата рождения обязательна для заполнения")
        @Past(message = "Дата рождения должна быть в прошлом")
        LocalDateTime birthDate,

        @NotBlank(message = "ИНН обязателен для заполнения")
        String inn,

        @NotBlank(message = "СНИЛС обязателен для заполнения")
        String snils,

        @NotBlank(message = "Номер паспорта обязателен для заполнения") String passNumber,

        @NotBlank(message = "Логин обязателен для заполнения") String login,

        @NotBlank(message = "Пароль обязателен для заполнения")
        @Size(min = 6, message = "Пароль должен содержать не менее 6 символов")
        String password) { }
