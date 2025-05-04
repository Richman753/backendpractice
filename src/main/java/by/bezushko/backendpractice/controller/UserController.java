package by.bezushko.backendpractice.controller;

import by.bezushko.backendpractice.dto.UserDto;
import by.bezushko.backendpractice.mapper.UserMapper;
import by.bezushko.backendpractice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/backend/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/get/all")
    public List<UserDto> getUsers()
    {
        return userService.getUsers().stream().map(userMapper::toDto).toList();
    }

    @GetMapping("/get/{passNumber}")
    public UserDto getUserByPassNumber(@PathVariable String passNumber)
    {
        return userMapper.toDto(userService.getUserByPassNumber(passNumber));
    }

    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto)
    {
        return userMapper.toDto(userService.createUser(userMapper.toObject(userDto)));
    }

    @PutMapping("/update/{passNumber}")
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable String passNumber) throws NoSuchFieldException {
        return userMapper.toDto(userService.updateUser(passNumber, userMapper.toObject(userDto)));
    }

    @DeleteMapping("/delete/{passNumber}")
    public UserDto deleteUser(@PathVariable String passNumber)
    {
        return userMapper.toDto(userService.deleteUser(passNumber));
    }

}
