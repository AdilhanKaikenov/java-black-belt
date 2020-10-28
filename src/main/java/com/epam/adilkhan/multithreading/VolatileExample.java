package com.epam.adilkhan.multithreading;

public class VolatileExample extends Thread {

    volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        System.out.println("The countdown begins ...");

        while (b) {
            counter++;
        }

        System.out.println("The loop is finished. The counter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample thread = new VolatileExample();
        thread.start();
        Thread.sleep(3000); // let it count three seconds
        System.out.println("After 3 seconds it is time to wake up!");
        thread.b = false;
        thread.join();
        System.out.println("End of the program.");
    }
}
