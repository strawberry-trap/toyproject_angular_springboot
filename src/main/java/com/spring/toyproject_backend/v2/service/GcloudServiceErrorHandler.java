package com.spring.toyproject_backend.v2.service;

import com.spring.toyproject_backend.v2.domain.GcloudEntity;
import com.spring.toyproject_backend.v2.value.Result;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GcloudServiceErrorHandler implements DatabaseErrorHandling<Result, GcloudEntity> {

    public GcloudServiceErrorHandler() {}

    @Override
    public Result generateResultWithListEmptyCheck(Iterable<GcloudEntity> list) {

        Result result = new Result();

        if (list == null || list.iterator().hasNext() == false) {
            result.setCode("EMPTY");
            result.setMessage("empty list");
        } else {
            result.setCode("SUCCESS");
            result.setMessage("successfully GET data");
            result.setData(list);
        }
        return result;
    }

    @Override
    public Result generateResultWithOptionalEmptyCheck(Optional<GcloudEntity> optional) {

        Result result = new Result();

        if (optional == null || optional.isPresent() == false) {
            result.setCode("EMPTY");
            result.setMessage("empty optional object");
        } else {
            result.setCode("SUCCESS");
            result.setMessage("successfully GET data");
            result.setData(optional.get());
        }
        return result;
    }
}
