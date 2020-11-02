package com.epam.adilkhan.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample_01 {
    public static void main(String[] args) throws InterruptedException {
        // ExecutorService is usually created to work with threads
        ExecutorService executorService = Executors.newFixedThreadPool(5); // factory method
        for (int i = 0; i < 10; i++) {
            executorService.execute(new ThreadPoolRunnable100Impl());
        }

        // The program will not finish its work, because the ExecutorService will wait for new tasks to be executed.
        // If we are not going to give new tasks, then we must terminate the ExecutorService by calling the shutdown() method.
        // So we say that there will be no more tasks, and the program will end as soon as all received tasks are completed.
        executorService.shutdown();

        // The awaitTermination() method is always called after the shutdown() method.
        // It works like join() method, it makes the thread wait on which it was called.
        // In this case, it was called on the main thread, so the main thread will wait.
        // The main thread will wait until the service does all the work, or if the specified time has not passed.
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Main thread ends");
    }
}

class ThreadPoolRunnable100Impl implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");

        // try-catch block can be commented to change the output result
        try {
            Thread.sleep(5000); // Sleep time can be increased to change the output result
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}