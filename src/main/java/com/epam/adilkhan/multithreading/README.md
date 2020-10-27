**Multithreading** is a principle of building a program in which several blocks of code can be executed 
simultaneously.

Basic goals: Performance and Concurrency (main goal -> performing several tasks at once)

Methods for creating threads:

```java
// Creation
public class MyThread extends Thread {
    @Override
    public void run() {
        // code
    }
}

// Launch
new MyThread().start();
```

If the class already has a parent (already inherited from someone)

```java
// Creation
public class MyThread implements Runnable {
    @Override
    public void run() {
        // code
    }
}

// Launch
Thread thread = new Thread(new MyThread());
thread.start();
```

Using anonymous class
```java
new Thread(() -> {code}).start();
```

**Thread states**
```java
Thread thread = new MyThread(); 
// NEW A thread that has not yet started is in this state.
thread.start();
// RUNNABLE - A thread executing in the Java virtual machine is in this state.
thread.join();
// TERMINATED - Once the task is completed, this thread enters the Terminated state
```