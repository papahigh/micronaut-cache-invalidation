package com.example;


import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.cache.annotation.CacheInvalidate;
import io.micronaut.cache.annotation.Cacheable;
import jakarta.inject.Singleton;

import java.time.LocalDateTime;

@Singleton
@CacheConfig("blocking-example-cache")
public class BlockingExampleService {

    @Cacheable
    LocalDateTime getByKey(String key) {
        return LocalDateTime.now();
    }

    @CacheInvalidate
    void resetCache(String key) {
    }
}
