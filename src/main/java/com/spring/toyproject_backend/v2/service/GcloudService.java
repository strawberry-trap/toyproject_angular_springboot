package com.spring.toyproject_backend.v2.service;

import com.spring.toyproject_backend.v2.domain.GcloudEntity;
import com.spring.toyproject_backend.v2.repository.GcloudRepository;
import com.spring.toyproject_backend.v2.value.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GcloudService {

    private GcloudRepository gcloudRepository;
    private GcloudServiceErrorHandler gcloudServiceErrorHandler;

    public GcloudService() {}

    @Autowired
    public GcloudService(GcloudRepository gcloudRepository, GcloudServiceErrorHandler gcloudServiceErrorHandler) {
        this.gcloudRepository = gcloudRepository;
        this.gcloudServiceErrorHandler = gcloudServiceErrorHandler;
    }

    @Transactional(readOnly = true)
    public Result getAllCloudAsList(Pageable pageable) {

        List<GcloudEntity> list = gcloudRepository.findAll();
        return gcloudServiceErrorHandler.generateResultWithListEmptyCheck(list);
    }

    @Transactional(readOnly = true)
    public Result getSingleCloud(Long id) {

        Optional<GcloudEntity> optGcloudEntity = gcloudRepository.findById(id);
        return gcloudServiceErrorHandler.generateResultWithOptionalEmptyCheck(optGcloudEntity);
    }

    @Transactional(readOnly = true)
    public Result getCloudListWithSearchWord(String searchText, Pageable pageable) {

        Page<GcloudEntity> list = gcloudRepository.getGcloudEntityList(searchText, pageable);
        return gcloudServiceErrorHandler.generateResultWithListEmptyCheck(list);
    }

}
