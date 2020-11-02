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

**Monitor concept**  
A monitor is an entity / mechanism that achieves correct operation during synchronization. 
In Java, every class and object has a monitor attached to it.

The monitor can have a status of free or busy. This is the mechanism used in Java when the synchronized keyword is used.
Thus, when one thread enters the area of code marked with the synchronized keyword, the object or class monitor takes on 
a busy state. At the same time, the monitor can only deal with one thread and no other thread can work with the code 
until the monitor becomes free again. The rest of the threads will wait until the monitor is free and then these threads 
will fight to occupy the monitor first.

This examples uses a monitor on the this object:
```java
public synchronized void abc() { method body };
```

```java
public void abc() {
    // not synchronized code...
    synchronized(this) {
        // synchronized code...
    }
};
```

In these examples, the object monitor this cannot be used, since the method is static, therefore the class monitor is used:
```java
public static synchronized void abc() { method body };
```

```java
public class MyClass {
    public static void abc() {
        // not synchronized code...
        synchronized(MyClass.class) {
            // synchronized code...
        }
    };
}
```

Block example:
```java
static final Object lock = new Object();

public void abc() { 
    // method body
    synchronized(lock) { 
        // block body 
    } 
    // method body 
}
```

**The wait and notify methods**  
The following methods are often used to notify other threads about its actions:
- `wait` - releases the monitor and puts the calling thread in a wait state until another thread calls the notify() method;
- `notify` –Do NOT release the monitor and wake up the thread on which the wait() method was previously called;
- `notifyAll` – DOES NOT release the monitor and wakes up all threads on which the wait() method was previously called;

When we call `wait()` – this forces the current thread to wait until some other thread invokes `notify()` or `notifyAll()` **on the same object**.
With `wait(long timeout)` method, we can specify a timeout after which thread will be woken up automatically. 
A thread can be woken up before reaching the timeout using `notify()` or `notifyAll()`. 

The `notify()` method is used for waking up threads that are waiting for an access to this object's monitor.

**DeadLock, LiveLock and Lock starvation**  
Deadlock - a situation when 2 or more threads are locked forever, waiting for each other and doing nothing.
To avoid this problem, you need to synchronize in the same order for different methods.

Livelock - a situation when 2 or more threads are locked forever, waiting for each other, doing some work, but without any progress.

Lock starvation is a situation when lower priority threads wait a long time or all the time in order to start.

**Lock and ReentrantLock**  
Lock is an interface that is implemented by the ReentrantLock class.
Just like the `synchronized` keyword, Lock is needed to achieve synchronization between threads.

Methods: lock(), unlock(), tryLock().

ReentrantLock
- Acquire Lock - Reentrant lock class provides lock() methods to get a lock  on the shared resource by thread 
- Release Lock - To release lock , programmers have to call unlock() method
- Ability to interrupt - lockInterruptibly() method can be used to interrupt the thread  
- Fairness - Constructor of this class has fairness parameter. If it is set to true then locks favor granting access to the longest-waiting thread
- Lock Release Order - Lock can be released in any order 

Synchronized
- Acquire Lock - You need to just write synchronized keyword to acquire a lock  
- Release Lock - It is done implicitly 
- Ability to interrupt - There is no way to interrupt the thread
- Fairness - Lock does not guarantee any particular  access orde
- Lock Release Order - Lock should be released in the same order in which they were acquired 

**Daemon Thread**  
Daemon threads are designed to perform background tasks and provide various services to User threads.  
When the last User thread is finished, the program ends its execution without waiting for the Daemon threads to finish.
If there are no user threads, then it is unnecessary to provide any services to them, and therefore we can stop our 
program without waiting for the end of the daemon thread.

**Interrupt threads**  
We have the ability to send a signal to the thread that we want to interrupt it.
We also have the ability to check in the thread itself if they want to interrupt it. 
It is up to the programmer to decide what to do if this check showed that they want to 
interrupt the thread.

**ThreadPool and ExecutorService**  
In practice, it is often necessary to create not one or two, but many threads. Creating a new thread is 
quite costly and can take a lot of time. When creating a thread, many processes take place behind 
the scenes in the Java virtual machine and operating system. In addition, it is inconvenient to 
manage separately created threads, the mechanism of thread pulls also more efficient in terms of the various processes 
that take place behind the scenes when we work with many threads.

Thread pool is a set of threads, each of which is designed to perform a particular task.

In Java, the most convenient way to work with thread pools is through the ExecutorService.
The most convenient way to create a thread pool is to use the factory methods of the Executors class:
```java
Executors.newFixedThreadPool(intcount) // will create a pool with 5 threads;
Executors.newSingleThreadExecutor() // will create a pool with 1 thread;
```

![multithreading-03](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/multithreading/etc/multithreading-03.jpg)

The thread works by performing tasks, after the task is completed, it is released and if there are pending tasks, 
it takes one task and starts executing it.

The `execute()` method passes our task to the thread pool, where it is executed by one of the threads.  
After executing the `shutdownExecutorService()` method, it realizes that there will be no more new tasks and, 
having completed the tasks that came before this, terminates.  
The `awaitTermination()` method forces the thread in which it is called to wait until one of two events is completed: 
either the ExecutorService terminates its work, or the time specified in the parameter of the `awaitTermination()` method has passed.

**ScheduledExecutorService**  
When we need to start a thread or several threads of their thread pool according to some schedule, 
then we need to use the ScheduledExecutorService.  
We use the ScheduledExecutorService when we want to set a schedule for starting threads from the pool.  

This pool is created using the factory method of the Executors class:
```java
Executors.newScheduledThreadPool(int count);
```

**Callable and Future**  
Callable, like Runnable, is a specific task that is executed by a thread.
Unlike Runnable Callable:
* Has a return type not void;
* May throw Exception;
* We can use Runnable with ExecutorService and when creating a new thread, while Callable we can use only with ExecutorService.

The submit method passes our task to the thread pool, for execution by one of the threads, and returns the Future type, 
which stores the result of our task execution.  
The get method allows you to get the result of the execution of our task from the Future object.  

When we submit and receive the Future object, the result of completing the task in the Future is not yet available. 
The result will be in the future when the task is fully completed. When we try to pull out the result of the task 
execution from the Future object, and this task has not finished its execution yet, then the thread in which the 
get method was called will be blocked until the task completes.

**Synchronizers Semaphore, CountDownLatch, Exchanger**  

**Semaphore**  
Semaphore is a synchronizer that allows you to restrict access to a certain resource. The Semaphore constructor needs 
to pass the number of threads that Semaphore will allow to use this resource at the same time.

![multithreading-04](https://raw.githubusercontent.com/AdilhanKaikenov/java-black-belt/master/src/main/java/com/epam/adilkhan/multithreading/etc/multithreading-04.jpg)

**CountDownLatch**  
CountDownLatch is a synchronizer that allows any number of threads to wait until a certain number of operations have completed. 
The CountDownLatch constructor must be passed the number of operations that must complete in order for the threads to continue their work.

**Exchanger**  
Exchanger is a synchronizer that allows data exchange between two threads, ensuring that both threads receive information from each other at the same time.  

