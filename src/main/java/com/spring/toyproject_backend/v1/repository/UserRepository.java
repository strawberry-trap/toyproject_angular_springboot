package com.spring.toyproject_backend.v1.repository;

import com.spring.toyproject_backend.v1.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // get one user
    Optional<UserEntity> findById(Long id);

    // get all users
    List<UserEntity> findAll();

    // delete single user
    void deleteById(Long id);

    UserEntity save(UserEntity user);

}
