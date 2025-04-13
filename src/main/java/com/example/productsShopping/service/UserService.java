package com.example.productsShopping.service;

import com.example.productsShopping.dto.UserProfileDto;
import com.example.productsShopping.model.User;
import com.example.productsShopping.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
        public UserProfileDto getUserProfile(String username) {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            return new UserProfileDto(user.getName(), user.getSurname(), user.getEmail(),user.getUsername());
        }
    }