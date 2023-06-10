package homework_nr_15;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new ThreadGenerator().start();
        }

        Thread t5 = new Thread(new ThreadGenerator1());
        Thread t6 = new Thread(new ThreadGenerator1());
        t5.start();
        t6.start();
        t5.join();
        t6.join();

        AtomicInteger count = new AtomicInteger(0);
        AtomicBoolean stop = new AtomicBoolean(false);
        new Thread(() -> {
            while (count.get() < 1000000 || !stop.get())
                count.incrementAndGet();
        }).start();
        new Thread(() -> {
            while (count.get() < 500000)
                System.out.println(count.get() + " " + Thread.currentThread().getName());
            stop.set(true);
            System.out.println("The number reached " + count.get() + " I stop the incrementials " + Thread.currentThread().getName());
        }).start();
    }
}

class ThreadGenerator extends Thread {
    @Override
    public void run() {
        System.out.println("Hello World " + getName());
    }
}

class ThreadGenerator1 implements Runnable {
    private static volatile int sharedNumber = 0;

    @Override
    public void run() {
        while (sharedNumber < 1000000)
            sharedNumber++;
        System.out.println(sharedNumber + " " + Thread.currentThread().getName());
    }
}


