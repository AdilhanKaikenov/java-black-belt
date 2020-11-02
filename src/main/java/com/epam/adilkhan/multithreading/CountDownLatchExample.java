package com.epam.adilkhan.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void marketStaffIsOnPlace() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Market staff came to work");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    public static void everythingIsReady() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Everything is ready, so let's open the market");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    public static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Market is opened");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    public static void main(String[] args) throws InterruptedException {

        new Friend("Pert", countDownLatch);
        new Friend("Elena", countDownLatch);
        new Friend("Oleg", countDownLatch);
        new Friend("Marina", countDownLatch);
        new Friend("Viktor", countDownLatch);

        marketStaffIsOnPlace();
        everythingIsReady();
        openMarket();
    }

}

class Friend extends Thread {

    private String name;

    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        try {
            /**
             * If the counter is greater than zero, then the thread will be blocked until the counter is zero.
             *
             * If the counter is already zero, then the thread will be able to perform its work without hindrance.
             */
            countDownLatch.await();
            System.out.println(name  + " started shopping");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}