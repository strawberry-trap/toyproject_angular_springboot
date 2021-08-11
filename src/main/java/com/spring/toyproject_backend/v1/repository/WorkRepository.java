package com.spring.toyproject_backend.v1.repository;

import com.spring.toyproject_backend.v1.model.WorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Long> {

}