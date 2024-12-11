# Multithreading in Java

## Introduction
This project demonstrates fundamental multithreading concepts in Java using two exercises. The first exercise showcases thread creation and execution, while the second exercise illustrates how threads can be used for parallel computation. Both exercises utilize the `Runnable` interface to define thread behavior.

---

## Exercise 1: Demonstrating Multi-threaded Behavior
In this exercise, we create a `Talkative` class that outputs a unique identifier 100 times. Multiple threads are instantiated to observe concurrent execution.

### Explanation
1. **Class Definition:** The `Talkative` class implements the `Runnable` interface, allowing it to define a `run` method for thread execution.
2. **Thread Creation:** Ten instances of `Thread` are created, each wrapping a `Talkative` instance with a unique integer.
3. **Thread Execution:** Using the `start` method, threads are executed, demonstrating non-deterministic execution order.

### Sample Code
```java
public class Talkative implements Runnable {
    int attribute;

    public Talkative(int attribute) {
        this.attribute = attribute;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(attribute);
        }
    }
}

// In the main method, create and start 10 threads:
Thread t1 = new Thread(new Talkative(1));
Thread t2 = new Thread(new Talkative(2));
// ... create threads up to t10

t1.start();
t2.start();
// Start all threads and observe output.
```

### Observation
The output demonstrates that threads run concurrently, with their outputs interleaved. This highlights Java's multi-threading capabilities.

---

## Exercise 2: Summing an Array Using Thread Pool
This exercise calculates the sum of an array in parallel using a pool of threads. It divides the array into segments, assigns each segment to a thread, and combines results to get the total sum.

### Explanation
1. **Class Definition:** The `Sommeur` class implements `Runnable` to compute the sum of a specific range within an array.
2. **Parallel Execution:** A pool of threads calculates sums for different array segments concurrently.
3. **Result Aggregation:** After threads finish execution, their results are combined to determine the total sum.

### Sample Code
```java
class Sommeur implements Runnable {
    private int[] array;
    private int start;
    private int end;
    private int sum;

    public Sommeur(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.sum = 0;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
    }
}

// In the main method, divide an array into segments and calculate sums:
Thread t1 = new Thread(new Sommeur(array, 0, 5));
Thread t2 = new Thread(new Sommeur(array, 5, 10));
t1.start();
t2.start();
```

### Observation
The results validate the correctness of parallel computation. Threads execute independently but contribute to the final result.

---

## Conclusion
This project highlights the power and flexibility of multithreading in Java. From simple concurrent execution to complex parallel computation, threads allow developers to harness system resources effectively. However, it also demonstrates the need to manage thread synchronization and order, especially in more complex scenarios. Understanding these concepts is crucial for writing efficient and robust multi-threaded applications.
