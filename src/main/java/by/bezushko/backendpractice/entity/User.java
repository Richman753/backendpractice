package by.bezushko.backendpractice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Users")
public class User {

    @NotBlank(message = "Имя обязательно для заполнения")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Фамилия обязательна для заполнения")
    @Column(name = "surname")
    private String surname;

    @NotNull(message = "Дата рождения обязательна для заполнения")
    @Past(message = "Дата рождения должна быть в прошлом")
    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @NotBlank(message = "ИНН обязателен для заполнения")
    @Column(name = "inn")
    private String inn;

    @NotBlank(message = "СНИЛС обязателен для заполнения")
    @Column(name = "snils")
    private String snils;

    @Id
    @NotBlank(message = "Номер паспорта обязателен для заполнения")
    @Column(name = "pass_number")
    private String passNumber;

    @NotBlank(message = "Логин обязателен для заполнения")
    @Column(name = "login")
    private String login;

    @NotBlank(message = "Пароль обязателен для заполнения")
    @Size(min = 6, message = "Пароль должен содержать не менее 6 символов")
    @Column(name = "password")
    private String password;
}
