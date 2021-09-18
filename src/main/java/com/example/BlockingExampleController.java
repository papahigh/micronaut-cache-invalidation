package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import java.time.LocalDateTime;

@Controller
@ExecuteOn(TaskExecutors.IO)
public class BlockingExampleController {
    final BlockingExampleService service;

    public BlockingExampleController(BlockingExampleService service) {
        this.service = service;
    }

    @Get("/blocking/{key}")
    LocalDateTime getByKey(String key) {
        return service.getByKey(key);
    }

    @Get("/blocking/{key}/reset")
    void resetCache(String key) {
        service.resetCache(key);
    }
}
