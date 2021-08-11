package com.spring.toyproject_backend.v1.service;

import com.spring.toyproject_backend.v1.model.UserEntity;
import com.spring.toyproject_backend.v1.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public UserEntity createUser(UserEntity user) {

        Long createdUserId = userRepository.save(user).getId();
        Optional<UserEntity> createdUser = getUserById(createdUserId);

        if (createdUser.isPresent()) {
            return createdUser.get();
        }
        UserEntity notCreated = new UserEntity();
        notCreated.setId((long)-1);

        return notCreated;
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

        logger.error("user not updated with id " + user.getId() + " and name : " + user.getFirstName() + " " + user.getLastName());
        UserEntity noResult = new UserEntity();
        noResult.setId((long)-1);
        return noResult;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);

        // check if successfully deleted
        Optional<UserEntity> shouldBeDeleted = userRepository.findById(id);
        if (shouldBeDeleted.isPresent()) {
            logger.error("user not deleted with id : " + shouldBeDeleted.get().getId());
        }

        return;
    }
}
