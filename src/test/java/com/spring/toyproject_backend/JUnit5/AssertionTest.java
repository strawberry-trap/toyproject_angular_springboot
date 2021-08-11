package com.spring.toyproject_backend.JUnit5;

import com.spring.toyproject_backend.v1.controller.UserController;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AssertionTest {

    @Autowired
    private UserController userController;

//    @BeforeAll
//    @Test
//    static void initializeInstances() {
//        return;
//    }
//
//    @AfterAll
//    @Test
//    static void freeResources() {
//        return;
//    }
//
//    @Test
//    @Order(1)
//    void getUserList() {
//        assert (userController.getUserList().hasBody() && userController.getUserList().getBody().size() > 0);
//    }
//
//    // will this executes 10*3 times ?
//    // parameterized test runs its own parameters with an iteration.
//    @RepeatedTest(3)
//    @ParameterizedTest
//    @ValueSource(longs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
//    void getUsersMultipleTimes(long randomId) {
//        assert (userController.getUser(randomId).getBody().getId() == randomId);
//    }
//
//    @Test
//    void exceptionThrower() {
////        Exception exception = assertThrows(ArithmeticException.class, ()->1/0);
//    }

}
