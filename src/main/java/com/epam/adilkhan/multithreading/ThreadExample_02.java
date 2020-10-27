package com.epam.adilkhan.multithreading;

public class ThreadExample_02 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Method Main begins");
        Thread thread = new Thread(new Worker());
        thread.start();

        // The thread in which join() is called will wait for the thread on which the join () method was called
        // thread.join() was called on the main thread, so the main thread will wait until the thread ends
        thread.join();

        // The main thread will wait until thead ends or until a second and a half have passed, which of these events happens first,
        // then it will urge the main thread to continue working
        // thread.join(1500);
        System.out.println("Method Main ends");
    }
}

class Worker implements Runnable {
    @Override
    public void run() {
        System.out.println("Work begins");

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Work ends");
    }
}