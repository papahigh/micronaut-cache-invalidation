package com.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@MicronautTest
class BlockingServiceTest {

    @Inject
    BlockingExampleService service;


    @Test
    void testCacheInvalidation() throws InterruptedException {
        var time = service.getByKey("key");
        Thread.sleep(100);
        assertEquals(time, service.getByKey("key"));

        service.resetCache("key");
        assertNotEquals(time, service.getByKey("key"));
    }
}