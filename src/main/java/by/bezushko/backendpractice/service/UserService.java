package by.bezushko.backendpractice.service;

import by.bezushko.backendpractice.dto.UserDto;
import by.bezushko.backendpractice.entity.User;
import by.bezushko.backendpractice.mapper.UserMapper;
import by.bezushko.backendpractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getUsers()
    {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    public UserDto getUserByPassNumber(String passNumber)
    {
        return userMapper.toDto(userRepository.getUserByPassNumber(passNumber));
    }

    public UserDto getUserById(UUID id)
    {
        return userMapper.toDto(userRepository.getById(id));
    }

    @Transactional
    public UserDto addUser(UserDto userDto)
    {
        return userMapper.toDto(userRepository.save(userMapper.toObject(userDto)));
    }

    @Transactional
    public void deleteUser(String passNumber)
    {
        userRepository.deleteById(userRepository.getUserByPassNumber(passNumber).getUserId());
    }

    @Transactional
    public UserDto updateUser(String passNumber, UserDto userDto)
    {
        User actual = userRepository.getUserByPassNumber(passNumber);
        userMapper.updateUser(userMapper.toObject(userDto), actual);
        actual.setPassNumber(passNumber);
        return userMapper.toDto(userRepository.save(actual));
    }
}
