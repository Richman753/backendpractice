package by.bezushko.backendpractice.service;

import by.bezushko.backendpractice.controller.UserController;
import by.bezushko.backendpractice.dto.UserDto;
import by.bezushko.backendpractice.service.UserService;
import by.bezushko.backendpractice.service.factory.UserTestFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUsers() {
        when(userService.getUsers()).thenReturn(Collections.emptyList());

        ResponseEntity<?> response = userController.getUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Collections.emptyList(), response.getBody());
        verify(userService, times(1)).getUsers();
    }

    @Test
    void getUserByPassNumber() {
        String passNumber = "123456";
        UserDto userDto = UserTestFactory.createUserDto();
        when(userService.getUserByPassNumber(passNumber)).thenReturn(userDto);

        ResponseEntity<?> response = userController.getUserByPassNumber(passNumber);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDto, response.getBody());
        verify(userService, times(1)).getUserByPassNumber(passNumber);
    }

    @Test
    void getUserById() {
        Long id = 1L;
        UserDto userDto = UserTestFactory.createUserDto();
        when(userService.getUserById(id)).thenReturn(userDto);

        ResponseEntity<?> response = userController.getUserById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDto, response.getBody());
        verify(userService, times(1)).getUserById(id);
    }

    @Test
    void addUser () {
        UserDto userDto = UserTestFactory.createUserDto();
        when(userService.addUser (any(UserDto.class))).thenReturn(userDto);

        ResponseEntity<?> response = userController.addUser (userDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDto, response.getBody());
        verify(userService, times(1)).addUser (userDto);
    }

    @Test
    void updateUser () throws NoSuchFieldException {
        String passNumber = "123456";
        UserDto userDto = UserTestFactory.createUserDto();
        when(userService.updateUser (eq(passNumber), any(UserDto.class))).thenReturn(userDto);

        ResponseEntity<?> response = userController.updateUser (passNumber, userDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDto, response.getBody());
        verify(userService, times(1)).updateUser (passNumber, userDto);
    }

    @Test
    void deleteUser () {
        String passNumber = "123456";

        ResponseEntity<?> response = userController.deleteUser (passNumber);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Сущность удалена", response.getBody());
        verify(userService, times(1)).deleteUser (passNumber);
    }
}
