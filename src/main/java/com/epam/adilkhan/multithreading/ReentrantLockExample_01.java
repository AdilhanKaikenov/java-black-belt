package com.epam.adilkhan.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample_01 {
    public static void main(String[] args) {
        Call call = new Call();

        Thread thread1 = new Thread(call::mobileCall);
        Thread thread2 = new Thread(call::skypeCall);
        Thread thread3 = new Thread(call::whatsappCall);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Call {

    private Lock lock = new ReentrantLock();

    public void mobileCall() {
        lock.lock();
        System.out.println("Object: " + this);
        System.out.println("Mobile call starts...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("Mobile call ends...");
    }

    public void skypeCall() {
        lock.lock();
        System.out.println("Object: " + this);
        System.out.println("Skype call starts...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("Skype call ends...");
    }

    public void whatsappCall() {
        lock.lock();
        System.out.println("Object: " + this);
        System.out.println("Whatsapp call starts...");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("Whatsapp call ends...");
    }
}