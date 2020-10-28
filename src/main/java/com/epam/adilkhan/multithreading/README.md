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

**Concurrency vs Parallelism**  
Concurrency means performing multiple tasks at once. Depending on the processor of the computer, 
concurrency can be achieved in different ways.

Parallelism means executing 2 or more tasks at the same time, that is, in parallel. 
In computers with a multi-core processor, concurrency can be achieved through parallelism.

**Asynchronous vs Synchronous**  
In synchronous programming, tasks are performed
sequentially one after another.

In asynchronous programming, each next task does NOT wait for the previous one to complete. Asynchronous
programming helps to achieve a concurrency.

In asynchronous programming, while one task is running, you can switch to another task without waiting 
for the first task to complete. Asynchronous programming helps us achieve competition because in 
synchronous programming, we don't execute tasks at the same time, they are executed sequentially. 
If you use asynchronous programming on a computer with many cores (multi-core processor) then parallelism 
can be achieved.

Synchronous programming is when tasks are performed sequentially. (To complete task 2, you need to wait 
until task 1 is completed). In asynchronous programming, you can perform multiple tasks at once. 
If the processor is single-core, then several tasks will be performed according to the principle Context switching.

In asynchronous programming, there is no order in the execution of threads, that is, the output is 
unpredictable, because all threads perform free work completely independently of each other. Thus, in 
asynchronous programming, the programmer cannot determine the order of execution of threads.

**Volatile**

The volatile keyword is used to mark a variable as being stored only in main memory.

To synchronize the value of a variable between threads, **the volatile keyword is used when only one 
thread can change the value of this variable, and other threads can only read it**.

The cache is a very fast memory area so that the cores do not access shared memory every time, 
they have their own cache and where they copy the value of variables.

![multithreading-01](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/multithreading/etc/multithreading-01.jpg)

**Data race and synchronized method**  

Data race is a problem that can arise when two or more threads access the same variable and at least 1 thread changes it.

![multithreading-02](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/multithreading/etc/multithreading-02.jpg)

Example of synchronized method:
```java
public synchronized void abc() { method body };
```