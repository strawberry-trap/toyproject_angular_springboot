package com.spring.toyproject_backend.v1.service;

import com.spring.toyproject_backend.v1.model.UserEntity;
import com.spring.toyproject_backend.v1.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ** moved NPE (no data from server) handling logic to UserController
    public Optional<UserEntity> getUserById(Long id) {

//        UserEntity result = new UserEntity();
//        try {
//            result = userRepository.getById(id);
//        } catch (Exception e) {
//            logger.warn("error caused in getEmployeeById method");
//            logger.error(e.getMessage());
//        }
        return userRepository.findById(id);
    }

    public List<UserEntity> getUserList() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> createUser(UserEntity user) {

        userRepository.save(user);

        // check successfully saved
        Optional<UserEntity> createdUser = this.getUserById(user.getId());
        if (createdUser.isPresent()) {
            return createdUser;
        }

        return createdUser;
    }

    public UserEntity updateUser(Long id, UserEntity user) {

        Optional<UserEntity> targetUser = userRepository.findById(id);
        if (targetUser.isPresent()) {

            UserEntity newUser = targetUser.get();
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setEmail((user.getEmail()));
            userRepository.save(newUser);

            return newUser;
        }
        UserEntity noResult = new UserEntity();
        noResult.setId(-1);
        return noResult;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        return;
    }
}
