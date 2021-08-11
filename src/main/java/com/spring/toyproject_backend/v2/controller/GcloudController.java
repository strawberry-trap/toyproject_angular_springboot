package com.spring.toyproject_backend.v2.controller;

import com.spring.toyproject_backend.v2.service.GcloudService;
import com.spring.toyproject_backend.v2.value.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GcloudController {

    private GcloudService gcloudService;

    public GcloudController() {}

    @Autowired
    public GcloudController(GcloudService gcloudService) {
        this.gcloudService = gcloudService;
    }

    @GetMapping("/cloudList")
    public Result getCloudList(Pageable pageable) {
        return gcloudService.getAllCloudAsList(pageable);
    }

    @GetMapping("/cloudListWithsearchWord")
    public Result getCloudListWithSearchWord(@PageableDefault(page=0, size=10, sort="id", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam String searchWord) {
        return gcloudService.getCloudListWithSearchWord(searchWord, pageable);
    }

    @GetMapping("/getCloud/{id}")
    public Result getSingleCloud(@PathVariable Long id){
        return gcloudService.getSingleCloud(id);
    }

}
