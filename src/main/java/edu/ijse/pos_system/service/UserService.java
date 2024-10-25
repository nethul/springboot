package edu.ijse.pos_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.ijse.pos_system.dto.UserLoginReq;
import edu.ijse.pos_system.entity.User;

@Service
public interface UserService {
    User createUser(User user);
    User findUserByUsername(String username);
    List<User> getAllUsers();
    void deleteUser(Long id);
    User findUserById(Long id);
    User updateUser(User user);
}
