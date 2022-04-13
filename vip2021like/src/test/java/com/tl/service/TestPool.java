package com.tl.service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestPool {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolMonitor = new ThreadPoolMonitor(10, 200, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10), "订单系统任务组1");
        for (int i = 1; i <= 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            threadPoolMonitor.execute(new MyTask(i));
        }
        threadPoolMonitor.shutdown();


    }


}


class MyTask implements Runnable {
    int i = 0;

    public MyTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000L);//业务逻辑
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "做第" + i + "个项目");
    }
}