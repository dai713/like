package com.tl;

import java.util.concurrent.CompletableFuture;

/***
 * 两个结果合并
 */
public class CompletableFuture02 {

    public static void main(String[] args) {
        try {
            String s = CompletableFuture.supplyAsync(() -> 1)
                    .thenCombine(CompletableFuture.supplyAsync( () -> "2" ), (a, b) -> {
                        System.out.println("a =" + a);
                        System.out.println("b =" + b);
                        return a + b;
                    })
                    .get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
