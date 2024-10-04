package com.example.planflow.services.implementation;

import com.example.planflow.dto.RequestUserDTO;
import com.example.planflow.dto.ResponseUserDTO;
import com.example.planflow.exception.NotFoundException;
import com.example.planflow.mapper.UserListMapper;
import com.example.planflow.mapper.UserMapper;
import com.example.planflow.models.User;
import com.example.planflow.repositories.UserRepository;
import com.example.planflow.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserListMapper userListMapper;

    @Override
    public List<ResponseUserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userListMapper.toUserRespList(users);
    }

    @Override
    public ResponseUserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user != null) {
            return userMapper.toRespDto(user);
        }
        throw new NotFoundException("User not found",404L);
    }

    @Override
    public ResponseUserDTO createUser(RequestUserDTO requestUserDTO) {
        User user = userRepository.save(userMapper.toUser(requestUserDTO));
        return userMapper.toRespDto(user);
    }

    @Override
    public ResponseUserDTO updateUser(RequestUserDTO requestUserDTO) {
        if(userRepository.existsById(requestUserDTO.getId())) {
            User newUser = userRepository.save(userMapper.toUser(requestUserDTO));
            return userMapper.toRespDto(newUser);
        }
        throw new NotFoundException("User not found",404L);
    }

    @Override
    public boolean deleteUser(Long userId) {
        if(userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        throw new NotFoundException("User not found",404L);
    }

    @Override
    public ResponseUserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        if(user != null) {
            return userMapper.toRespDto(user);
        }
        throw new NotFoundException("User not found",404L);
    }
}
