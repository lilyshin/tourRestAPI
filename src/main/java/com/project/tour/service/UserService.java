package com.project.tour.service;

import com.project.tour.entity.User;
import com.project.tour.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findById(String userId) {
        Optional<User> entity = userRepository.findById(userId);
        return entity;
    }
}