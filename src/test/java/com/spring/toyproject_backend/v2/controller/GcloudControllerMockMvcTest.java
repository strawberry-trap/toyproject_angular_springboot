package com.spring.toyproject_backend.v2.controller;

import com.spring.toyproject_backend.v2.service.GcloudService;

import com.spring.toyproject_backend.v2.value.Result;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ExtendWith(SpringExtension.class)
 * Tells JUnit5 to enable Spring support.
 * As of SpringBoot 2.1, loading SpringExtension is included in @DataJpaTest, @WebMvcTest, @SpringBootTest.
 *
 * @WebMvcTest(controllers = {})
 * Contains only the beans needed for testing a web controller.
 * 'controllers' parameter tells SpringBoot to restrict the application context created for this test
 * to the given controller bean and some framework beans needed for Spring Web Mvc.
 * Leaving the parameter empty will make SpringBoot to include all controllers in the application context.
 *
 * https://reflectoring.io/spring-boot-web-controller-test/
 * https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing.spring-boot-applications.with-mock-environment
 * */
// @ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = GcloudController.class)
public class GcloudControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GcloudService gcloudService;

    @Test
    void matchingHttpRequestMethodType() throws Exception {

        Result result = new Result();
        result.setMessage("[GET] successful.");
        result.setData("dummy data");
        result.setCode("SUCCESS");

        given( this.gcloudService.getAllCloudAsList(any()) )
                .willReturn(result);

        this.mockMvc.perform(get("/cloudList"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void returningValueValidationCheck() throws Exception {

        Result result = new Result();
        result.setMessage("[GET] successful.");
        result.setData("dummy data");
        result.setCode("SUCCESS");

        given( this.gcloudService.getAllCloudAsList(any()) )
                .willReturn(result);

        MvcResult mvcResult = this.mockMvc.perform(get("/cloudList")).andReturn();

        // use this to compare if actual response body is the same as expected result.
        String jsonBodyAsString = mvcResult.getResponse().getContentAsString();

        // verifies if the service method is actually executed
        verify(gcloudService).getAllCloudAsList(any());

    }

}
