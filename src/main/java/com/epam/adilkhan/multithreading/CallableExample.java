package com.epam.adilkhan.multithreading;

import java.util.concurrent.*;

public class CallableExample {

    static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new Factorial(5));
        try {
            System.out.println("Хотим получит результат. isDone? - " + future.isDone());
            // The get method blocks the main thread until the task completes its work
            factorialResult = future.get();
            System.out.println("Получили результат. isDone? - " + future.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        } finally {
            executorService.shutdown();
        }

        System.out.println(factorialResult);
    }
}

class Factorial implements Callable<Integer> {

    private int f;

    public Factorial(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f < 0) {
            throw new Exception("Вы ввели неверное число!");
        }

        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }

        Thread.sleep(4000);

        return result;
    }
}
