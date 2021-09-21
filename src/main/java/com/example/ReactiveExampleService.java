package com.example;

import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.cache.annotation.CacheInvalidate;
import io.micronaut.cache.annotation.Cacheable;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

import java.time.Clock;
import java.time.LocalDateTime;

@Singleton
@CacheConfig("example-reactive-cache")
public class ReactiveExampleService {

    @Cacheable
    Mono<LocalDateTime> getByKey(String key) {
        return Mono.just(LocalDateTime.now(Clock.systemUTC()));
    }

    @CacheInvalidate
    Mono<Void> resetCache(String key) {
        return Mono.empty();
    }
}
