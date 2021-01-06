package com.example.springbootlearn.service;

import com.example.springbootlearn.expection.DataNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class BusinessService {
    public String getBusiness() {
        return "Hello Business";
    }

    public String getBusiness2() {
        return "Hello Business 2";
    }

    @Retryable(value = {DataNotFound.class}, backoff = @Backoff(delay = 3000))
    public String getBusinessRetry(boolean simulateretry, boolean simulateretryfallback) {
        log.info("One : {} {}", simulateretry, simulateretryfallback);
        if (simulateretry) {
            if (simulateretryfallback) {
                throw new DataNotFound("Must fallback as all retry will get exception!!!");
            }
        }
        return "Retry working";
    }

    @Recover
    public String fallback(RuntimeException e) {
        log.info("Inside retry: {}", e.getMessage());
        return "REcovering";
    }
}
