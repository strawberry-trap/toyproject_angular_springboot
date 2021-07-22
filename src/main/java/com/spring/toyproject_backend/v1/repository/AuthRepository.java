package com.spring.toyproject_backend.v1.repository;

import com.spring.toyproject_backend.v1.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<UserEntity, Long> {

}
