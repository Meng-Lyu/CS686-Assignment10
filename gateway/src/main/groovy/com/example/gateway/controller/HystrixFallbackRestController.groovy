package com.example.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HystrixFallbackRestController {

    @GetMapping("/service1/fallback")
    public Mono<String> getFxSvcMsg() {
        return Mono.just("No response from service1.");
    }

}
