package com.epam.adilkhan.multithreading;

public class ThreadExample_01 implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadExample_01());
        thread.setName("my-thread-01");

        /**
         * It is possible to specify the priority of a thread, but no one guarantees that this thread will be executed according to its priority.
         *
         * min priority 1
         * max priority 10
         * default priority 5
         */
        thread.setPriority(9);
        thread.start();

        // Never call the run () method. The fact is that by calling this method, the thread is not started. If called manually,
        // then the code will be executed as part of the main thread.
        // thread.run();

        System.out.println("Method main(). Thread name: " + Thread.currentThread().getName());

    }

    @Override
    public void run() {
        System.out.println("Method run(). Thread name: " + Thread.currentThread().getName());
    }
}
