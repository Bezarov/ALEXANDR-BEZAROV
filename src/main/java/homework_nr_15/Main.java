package homework_nr_15;

import java.util.concurrent.ArrayBlockingQueue;

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

        ArrayBlockingQueue<Integer> synArray = new ArrayBlockingQueue<>(1, true);
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                try {
                    synArray.put(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(() -> {
            while (synArray.peek() < 50000) {
                try {
                    Thread.sleep(1);
                    System.out.println(synArray.take() + " " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
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


