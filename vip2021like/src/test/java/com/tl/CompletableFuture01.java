package com.tl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFuture01 {

    private static CompletableFuture<Integer> m1(){
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1111;
        });
    }
    private static CompletableFuture<Integer> m2(){
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2222;
        });
    }

    /***
     * acceptEither函数
     * 那个线程跑的快用哪个
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        m1().acceptEither(m2(), t -> {
            System.out.println("t = " + t);
        }).get();
    }
}