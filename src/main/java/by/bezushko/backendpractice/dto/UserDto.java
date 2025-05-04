package by.bezushko.backendpractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String surname;
    private LocalDateTime birthDate;
    private String inn;
    private String snils;
    private String passNumber;
    private String login;
    private String password;
}
