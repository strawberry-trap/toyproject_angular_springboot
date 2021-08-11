package com.spring.toyproject_backend.v1.controller;

import com.spring.toyproject_backend.v1.model.WorkEntity;
import com.spring.toyproject_backend.v1.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class WorkController {

    private WorkService workService;
    Logger logger = LoggerFactory.getLogger(WorkService.class);

    public WorkController(WorkService workService) { this.workService = workService; }

    // get all
    @GetMapping("/workList")
    public ResponseEntity<List<WorkEntity>> getWorkList() {

        List<WorkEntity> workList = new ArrayList<WorkEntity>();
        workList = workService.getWorkList();

        if (workList.size() == 0) {
            logger.warn("getWorkList() method in WorkController.java returned an array of size 0.");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(workList);
    }

    // get one
    @GetMapping("/work/{id}")
    public ResponseEntity<WorkEntity> getWork(@PathVariable Long id) {

        Optional<WorkEntity> work = workService.getWorkById(id);

        if (work.isPresent()) {
            return ResponseEntity.ok(work.get());
        }
        else {
            return ResponseEntity.noContent().build();
        }

    }

    // create

    // update

    // delete


}
