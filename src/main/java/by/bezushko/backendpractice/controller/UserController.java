package by.bezushko.backendpractice.controller;

import by.bezushko.backendpractice.dto.UserDto;
import by.bezushko.backendpractice.mapper.UserMapper;
import by.bezushko.backendpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/backend/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> getUsers()
    {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/pass/{passNumber}")
    public ResponseEntity<?> getUserByPassNumber(@PathVariable String passNumber)
    {
        return new ResponseEntity<>(userService.getUserByPassNumber(passNumber), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id)
    {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto)
    {
        return new ResponseEntity<>(userService.addUser(userDto), HttpStatus.OK);
    }

    @PutMapping("/update/{passNumber}")
    public ResponseEntity<?> updateUser(@PathVariable String passNumber, @RequestBody UserDto userDto) throws NoSuchFieldException {
        return new ResponseEntity<>(userService.updateUser(passNumber, userDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{passNumber}")
    public ResponseEntity<?> deleteUser(@PathVariable String passNumber)
    {
        userService.deleteUser(passNumber);
        return new ResponseEntity<>("Сущность удалена", HttpStatus.OK);
    }

}
