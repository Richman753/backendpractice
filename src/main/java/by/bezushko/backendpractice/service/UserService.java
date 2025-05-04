package by.bezushko.backendpractice.service;

import by.bezushko.backendpractice.entity.User;
import by.bezushko.backendpractice.mapper.UserMapper;
import by.bezushko.backendpractice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public User getUserByPassNumber(String passNumber)
    {
        return userRepository.getUserByPassNumber(passNumber);
    }

    @Transactional
    public User createUser(User user)
    {
        return userRepository.save(user);
    }

    @Transactional
    public User deleteUser(String passNumber)
    {
        User user = userRepository.getUserByPassNumber(passNumber);
        userRepository.deleteById(passNumber);
        return user;
    }

    @Transactional
    public User updateUser(String passNumber, User user)
    {
        User actual = userRepository.getUserByPassNumber(passNumber);
        userMapper.updateUser(user, actual);
        actual.setPassNumber(passNumber);
        return userRepository.save(actual);
    }
}
