package com.arthurlevi.usermicroservice.services;

import com.arthurlevi.usermicroservice.dtos.UserRecordDto;
import com.arthurlevi.usermicroservice.models.UserModel;
import com.arthurlevi.usermicroservice.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

}
