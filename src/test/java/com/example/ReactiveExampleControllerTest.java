package com.example;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class ReactiveExampleControllerTest {

    @Inject
    ReactiveExampleService service;

    @Test
    void testCacheInvalidation() throws InterruptedException {
        var time = service.getByKey("key").block();
        Thread.sleep(100);
        assertEquals(time, service.getByKey("key").block());

        service.resetCache("key").block();
        assertNotEquals(time, service.getByKey("key").block());
    }

}