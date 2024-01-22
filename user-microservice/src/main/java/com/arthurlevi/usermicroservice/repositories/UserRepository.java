package com.arthurlevi.usermicroservice.repositories;

import com.arthurlevi.usermicroservice.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
