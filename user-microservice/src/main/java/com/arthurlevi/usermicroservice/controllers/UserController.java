package com.arthurlevi.usermicroservice.controllers;

import com.arthurlevi.usermicroservice.dtos.UserRecordDto;
import com.arthurlevi.usermicroservice.models.UserModel;
import com.arthurlevi.usermicroservice.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity <UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto){
        var user = new UserModel();

        BeanUtils.copyProperties(userRecordDto,user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

}
