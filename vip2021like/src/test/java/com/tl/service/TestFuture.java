package com.tl.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TestFuture {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> result = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(5);
            return 300;
        });
        System.out.println(result.get());
    }
}
