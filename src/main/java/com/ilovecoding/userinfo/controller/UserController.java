package com.ilovecoding.userinfo.controller;

import com.ilovecoding.userinfo.dto.UserDTO;
import com.ilovecoding.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        UserDTO savedUser=this.userService.saveUserInDb(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUserById/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("userId") Integer userId){
       return new ResponseEntity<>(this.userService.fetchUerDetailsById(userId),HttpStatus.OK);
    }



    
}
