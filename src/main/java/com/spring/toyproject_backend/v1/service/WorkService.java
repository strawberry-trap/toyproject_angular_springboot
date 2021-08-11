package com.spring.toyproject_backend.v1.service;

import com.spring.toyproject_backend.v1.model.WorkEntity;
import com.spring.toyproject_backend.v1.repository.WorkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkService {

    WorkRepository workRepository;
    Logger logger = LoggerFactory.getLogger(WorkService.class);

    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    // get single work
    public Optional<WorkEntity> getWorkById(Long id){

        Optional<WorkEntity> result = workRepository.findById(id);

        // should check if it shows a "readable" information
        logger.info(result.get().toString());
        return result;
    }

    // get all works
    public List<WorkEntity> getWorkList() {

        List<WorkEntity> result = workRepository.findAll();
        logger.info("get all work as a list, with size : " + result.size());

        return result;
    }

    public Optional<WorkEntity> createWork(WorkEntity work) {

        workRepository.save(work);

        // check successfully saved
        Optional<WorkEntity> createdWork = this.getWorkById(work.getId());
        if (createdWork.isPresent()) {
            logger.info("work created", createdWork.get());
            return createdWork;
        }

        logger.error("work not created", createdWork.get());
        return createdWork;
    }

    public WorkEntity updateWork(Long id, WorkEntity work) {

        Optional<WorkEntity> targetWork = workRepository.findById(id);
        if (targetWork.isPresent()) {

            WorkEntity newWork = targetWork.get();
            newWork.setName(work.getName());
            newWork.setDueDate(work.getDueDate());
            workRepository.save(newWork);

            return newWork;
        }

        logger.error("work not updated with id " + work.getId() + " and name : " + work.getName());
        WorkEntity noResult = new WorkEntity();
        noResult.setId((long)-1);
        return noResult;
    }

    public void deleteWork(Long id) {
        workRepository.deleteById(id);

        // check if successfully deleted
        Optional<WorkEntity> shouldBeDeleted = workRepository.findById(id);
        if (shouldBeDeleted.isPresent()) {
            logger.error("work not deleted with id : " + shouldBeDeleted.get().getId());
        }

        return;
    }

}
