package com.example;


import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Controller
public class ReactiveExampleController {

    final ReactiveExampleService service;

    public ReactiveExampleController(ReactiveExampleService service) {
        this.service = service;
    }

    @Get("/reactive/{key}")
    Mono<LocalDateTime> getByKey(String key) {
        return service.getByKey(key);
    }

    @Get("/reactive/{key}/reset")
    Mono<Void> resetCache(String key) {
        return service.resetCache(key);
    }
}
