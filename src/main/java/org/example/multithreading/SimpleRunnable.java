package org.example.multithreading;

public class SimpleRunnable implements Runnable {

    public volatile boolean running = true;

    @Override
    public void run() {
        System.out.println("Thread " + this.toString() + " is running ...");

        int count = 0;
        int interval = 1000;

        while (running) {
            try {
                Thread.sleep(interval);
                System.out.println("Thread " + this.toString() + " waited for " + ++count + " seconds");
            } catch (InterruptedException e) {
                System.out.println("Thread " + this.toString() + " interrupted");
            }
        }

        System.out.println("Thread " + this.toString() + " finished");
    }
}
