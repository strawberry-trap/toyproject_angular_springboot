package com.spring.toyproject_backend.v1.repository;

import com.spring.toyproject_backend.v1.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {



}
