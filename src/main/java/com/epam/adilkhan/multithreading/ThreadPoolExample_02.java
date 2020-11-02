package com.epam.adilkhan.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample_02 {
    public static void main(String[] args) throws InterruptedException {
        // This ExecutorService should be used when we need to set a schedule for running threads.
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

//        for (int i = 0; i < 10; i++) {
//            scheduledExecutorService.execute(new ThreadPoolRunnable200Impl());
//        }

//        scheduledExecutorService.schedule(new ThreadPoolRunnable200Impl(), 5, TimeUnit.SECONDS);

//        scheduledExecutorService.scheduleAtFixedRate(new ThreadPoolRunnable200Impl(), 5, 1, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(new ThreadPoolRunnable200Impl(), 5, 2, TimeUnit.SECONDS);


        Thread.sleep(10000);
        scheduledExecutorService.shutdown();
    }
}

class ThreadPoolRunnable200Impl implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");

        // try-catch block can be commented to change the output result
        try {
            Thread.sleep(500); // Sleep time can be increased to change the output result
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}