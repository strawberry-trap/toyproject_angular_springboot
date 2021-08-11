package com.spring.toyproject_backend.JUnit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Timeout(10) // class level timeout does not apply to lifecycle methods.
public class JUnitTimeout {

    @BeforeEach
    @Timeout(5) // fails the test if execution time exceeds 5 seconds
    void setUp () {

    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS) // fails if execution time exceeds 100 milliseconds
    void timeOutTest() {

    }

    @Test
    @Timeout(5)
    void pollUntil() throws InterruptedException {

        // say, this data is sent from server via asynchronous transaction
        List<Object> sampleData = new ArrayList<>();

        while(sampleData.isEmpty()) {
            Thread.sleep(250); // my own waiting term
        }
        // proceed logic with 'sampleData'
    }

}
