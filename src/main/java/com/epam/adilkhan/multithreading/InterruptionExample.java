package com.epam.adilkhan.multithreading;

public class InterruptionExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts");
        Thread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000);
        // The interrupt() method does not interrupt the thread.
        // We cannot interrupt one thread from another, but the thread can check if anyone wants to interrupt it.
        thread.interrupt(); // The Main thread wants to interrupt the InterruptedThread

        thread.join();
        System.out.println("Main thread ends");
    }
}

class InterruptedThread extends Thread {
    double sqrtSum = 0.0;

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000_000; i++) {
            // Here we ourselves decide what to do, if they want to interrupt the thread, we can interrupt it or continue its work.
            if (isInterrupted()) {
                System.out.println("Поток хотят прервать.");
                System.out.println("Убеждаюсь что состояние всех объектов впорядке и решаю завершить поток.");
                System.out.println(sqrtSum);
                return; // decided to interrupt the thread
            }
            sqrtSum += Math.sqrt(i);

            // this try-catch block can be commented out to change the result
            try {
                sleep(100);
            } catch (InterruptedException e) {
                // This exception is thrown when our thread is sleeping, but someone wants to interrupt it.
                // This is done so that we can immediately know about it.
                System.out.println("Поток хотят прервать во время сна. Давайте завершим его работу.");
                System.out.println(sqrtSum);
                return; // decided to interrupt the thread
            }
        }
        System.out.println(sqrtSum);
    }
}
