package by.bezushko.backendpractice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.cglib.core.GeneratorStrategy;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    @JdbcTypeCode(Types.CHAR)
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "inn")
    private String inn;

    @Column(name = "snils")
    private String snils;

    @Column(name = "pass_number")
    private String passNumber;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;
}
