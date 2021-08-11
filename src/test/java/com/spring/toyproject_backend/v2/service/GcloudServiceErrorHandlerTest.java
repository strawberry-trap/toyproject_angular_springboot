package com.spring.toyproject_backend.v2.service;

import com.spring.toyproject_backend.v2.domain.GcloudEntity;
import com.spring.toyproject_backend.v2.value.Result;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
public class GcloudServiceErrorHandlerTest {

    @Autowired // JUnit5 DI works only with @Autowired
    private GcloudServiceErrorHandler gcloudServiceErrorHandler;

    @Test
    @DisplayName("Iterable type empty check")
    public void iterableEmptyCheck() {

        ArrayList<GcloudEntity> mockList = new ArrayList<GcloudEntity>();
        Result result = this.gcloudServiceErrorHandler.generateResultWithListEmptyCheck(mockList);
        Assertions.assertEquals(result.getCode(), "EMPTY");
    }

    @Test
    @DisplayName("Iterable type NOT empty check")
    public void iterableNotEmptyCheck() {

        ArrayList<GcloudEntity> mockList = new ArrayList<GcloudEntity>();
        mockList.add(new GcloudEntity());
        Result result = this.gcloudServiceErrorHandler.generateResultWithListEmptyCheck(mockList);

        Assertions.assertAll(
                () -> Assertions.assertEquals(result.getCode(), "SUCCESS"),
                () -> Assertions.assertNotNull(result.getData())
        );
    }

    @Test
    @DisplayName("Optional type empty check")
    public void optionalEmptyCheck() {

        Optional<GcloudEntity> mockOptionalObject = Optional.empty();
        Result result = this.gcloudServiceErrorHandler.generateResultWithOptionalEmptyCheck(mockOptionalObject);
        Assertions.assertEquals(result.getCode(), "EMPTY");
    }

    @Test
    @DisplayName("Optional type NOT empty check")
    public void optionalNotEmptyCheck() {

        Optional<GcloudEntity> mockOptionalObject = Optional.of(new GcloudEntity());
        Result result = this.gcloudServiceErrorHandler.generateResultWithOptionalEmptyCheck(mockOptionalObject);

        Assertions.assertAll(
                () -> Assertions.assertEquals(result.getCode(), "SUCCESS"),
                () -> Assertions.assertNotNull(result.getData())
        );
    }

    @Test
    @DisplayName("given null as input parameter")
    public void nullInputParameterTest() {

        Result result = this.gcloudServiceErrorHandler.generateResultWithOptionalEmptyCheck(null);
        Assertions.assertEquals(result.getCode(), "EMPTY");
    }
}
