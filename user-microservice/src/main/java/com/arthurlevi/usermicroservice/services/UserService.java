package com.arthurlevi.usermicroservice.services;

import com.arthurlevi.usermicroservice.dtos.UserRecordDto;
import com.arthurlevi.usermicroservice.models.UserModel;
import com.arthurlevi.usermicroservice.producer.UserProducer;
import com.arthurlevi.usermicroservice.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    final UserRepository userRepository;
    final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel save(UserModel userModel){
        userModel = userRepository.save(userModel);
        userProducer.publishmessageEmail(userModel);
        return userModel;
    }

}
