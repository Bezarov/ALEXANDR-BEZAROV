package homework_nr_15;
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

        Producer t7 = new Producer();
        Consumer t8 = new Consumer();
        t7.start();
        t8.start();

//        new Thread(() -> {
//            synchronized (threadGenerator2.sharedNumber) {
//                synchronized (threadGenerator2.stop) {
//                    while (threadGenerator2.sharedNumber <= 500000 && !threadGenerator2.stop) {
//                        System.out.println(threadGenerator2.sharedNumber + " " + Thread.currentThread().getName());
//                        Thread.currentThread().notify();
//                        try {
//                            Thread.currentThread().wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }
//            }
//            threadGenerator2.stop = true;
//            System.out.println("Stopped " + threadGenerator2.sharedNumber + " " + Thread.currentThread().getName());
//        }).start();
    }

    static class ThreadGenerator extends Thread {
        @Override
        public void run() {
            System.out.println("Hello World " + getName());
        }
    }

    static class ThreadGenerator1 implements Runnable {
        private static volatile int sharedNumber = 0;
        @Override
        public void run() {
            while (sharedNumber < 1000000)
                sharedNumber++;
            System.out.println(sharedNumber + " " + Thread.currentThread().getName());
        }
    }
    static class Producer extends Thread {
        public static volatile Integer sharedNumber = 0;
        public static volatile Boolean stop = false;
        @Override
        public void run() {
            while (sharedNumber <= 1000000 && !stop) {
                synchronized (sharedNumber) {
                    sharedNumber++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    static class Consumer extends Thread {
        @Override
        public void run() {
            synchronized (Producer.sharedNumber) {
                while (Producer.sharedNumber <= 500000) {
                    System.out.println(Producer.sharedNumber + " " + Thread.currentThread().getName());
                    notifyAll();
                }
                Producer.stop = true;
                System.out.println("Stopped " + Producer.sharedNumber + " " + Thread.currentThread().getName());
            }
        }
    }
}


