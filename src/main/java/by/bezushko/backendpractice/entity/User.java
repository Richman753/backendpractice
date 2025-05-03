package by.bezushko.backendpractice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "Users")
public class User {
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
    @Id
    @Column(name = "pass_number")
    private String passNumber;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
}
