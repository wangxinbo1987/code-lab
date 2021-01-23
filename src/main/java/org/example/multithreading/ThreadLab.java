package org.example.multithreading;

public class ThreadLab {

    private void simpleStartThread() {
        /**
         * Option 1 : Define a thread class by extending the Thread class
         */
        Thread t1 = new SimpleThread();

        /**
         * Option 2 : Define a thread class by implementing Runnable interface and pass it to Thread class as construction parameter
         */
        SimpleRunnable simpleRunnable = new SimpleRunnable();
        Thread t2 = new Thread(simpleRunnable);

        /**
         * Start threads
         */
        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);

            /**
             * Interrupt thread 1 by invoking interrupt()
             */
            t1.interrupt();
            t1.join();

            /**
             * Interrupt thread 2 by setting running flag to false
             */
            simpleRunnable.running = false;
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Sub thread interrupted");
        }

        /**
         * this is a daemon thread, which will not be terminated when JVM quit
         */
        Thread t3 = new SimpleThread();
        t3.setDaemon(true);
        t3.start();

        System.out.println("Main thread finished");
    }

    public static void main(String[] args) {
        ThreadLab threadLab = new ThreadLab();
        threadLab.simpleStartThread();
    }
}
