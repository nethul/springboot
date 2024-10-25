package edu.ijse.pos_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ijse.pos_system.dto.UserLoginReq;
import edu.ijse.pos_system.entity.User;
import edu.ijse.pos_system.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(201).body(createdUser);
    }

    @PostMapping("/userLogin")
    public ResponseEntity<User> findUserByUsername(@RequestBody UserLoginReq username){
        User user = userService.findUserByUsername(username.getUsername());
        System.out.println(user);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("success");
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        User existingUser = userService.findUserById(id);
        existingUser.setFullName(user.getFullName());
        existingUser.setBirthDate(user.getBirthDate());
        existingUser.setAddress(user.getAddress());
        existingUser.setGender(user.getGender());
        existingUser.setMobileNumber(user.getMobileNumber());
        existingUser.setMobileNumber(user.getMobileNumber());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());

        return ResponseEntity.status(200).body(userService.updateUser(existingUser));
    }


}
