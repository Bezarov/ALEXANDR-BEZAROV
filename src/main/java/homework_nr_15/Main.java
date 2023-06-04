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

//        ArrayBlockingQueue<Integer> synArray = new ArrayBlockingQueue<>(1, true);
//        new Thread(() -> {
//            for(int i = 0; i < 100000; i++) {
//                try {
//                    synArray.put(i);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();
//        new Thread(() -> {
//            while (synArray.peek() < 50000) {
//                try {
//                    System.out.println(synArray.take() + " " + Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();


        Thread t7 = new Thread(new Runnable1());
        t7.start();
        Thread t8 = new Thread(new Runnable2());
        t8.start();
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

class SynArray {
    ArrayBlockingQueue<Integer> synArray = new ArrayBlockingQueue<>(2);
    boolean stop = false;
    public void producer() throws InterruptedException {
        for (int i = 1; i < 100000 || !stop; i++) {
            synArray.put(i);
        }
    }
    public void consumer() throws InterruptedException {
        while (!stop) {
            int arrayNumber = synArray.take();
            if (arrayNumber > 50000) {
                stop = true;
                System.out.println("Stopped - number reached: ");
            }
            System.out.println(arrayNumber + " " + Thread.currentThread().getName());
        }
    }
}
class Runnable1 extends SynArray implements Runnable {
    @Override
    public void run() {
        try {
            producer();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Runnable2 extends SynArray implements Runnable{
    @Override
    public void run() {
        try {
            consumer();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


