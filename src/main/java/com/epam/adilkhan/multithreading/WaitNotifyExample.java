package com.epam.adilkhan.multithreading;

public class WaitNotifyExample {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}

class Market {
    private int breadCount = 0;

    /**
     * With wait () in the getBread () method, we wait for the producer to add new bread. And after adding, we call notify (),
     * as if saying that the store is now empty again, and you can add more.
     */
    public synchronized void getBread() {
        while (breadCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount--;

        System.out.println("Consumer bought one bread.");
        System.out.println("The amount of bread on the market = " + breadCount);
        notify();
    }

    /**
     * In the putBread () method using wait (), we are waiting for space to be freed. After the space is free, add bread and notify
     * the consumer through notify () that he can pick up bread.
     */
    public synchronized void putBread() {
        while (breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;

        System.out.println("Producer added one bread.");
        System.out.println("The amount of bread on the market = " + breadCount);
        notify();
    }
}

class Producer implements Runnable {

    private Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {

    private Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}