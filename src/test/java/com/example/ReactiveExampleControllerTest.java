package com.example;

import com.example.BlockingExampleControllerTest.BlockingClient;
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
    ReactiveClient client;

    @Test
    void testCacheInvalidation() throws InterruptedException {
        var time = client.getTime("key");
        Thread.sleep(100);
        assertEquals(time, client.getTime("key"));

        client.reset("key");
        assertNotEquals(time, client.getTime("key"));
    }

    @Client("http://localhost:8080")
    interface ReactiveClient {
        @Get("/reactive/{key}")
        LocalDateTime getTime(String key);
        @Get("/reactive/{key}/reset")
        void reset(String key);
    }
}