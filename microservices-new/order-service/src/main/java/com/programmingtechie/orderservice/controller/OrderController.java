package com.programmingtechie.orderservice.controller;


import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.model.Order;
import com.programmingtechie.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // this name inventory is from application properties we have specified in resilience4j.instances.inventory, we can specify anything here
    // Place order method will be implemented in different thread and once timeout is reached it throws execption
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture <String> placeOrder(@RequestBody OrderRequest orderRequest){
        return CompletableFuture.supplyAsync(()->orderService.placeOrder(orderRequest));
//        return "OrderRequest is placed successfully";
    }

    // This is we saw failed entries here
    public CompletableFuture fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException){
            return CompletableFuture.supplyAsync(()->"Oops ! Something went wrong , please order after some time");
    }

}
