package org.example.multithreading;

public class SimpleThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread " + this.getName() + " is running ...");

        int count = 0;
        int interval = 1000;

        while (!isInterrupted()) {
            try {
                Thread.sleep(interval);
                System.out.println("Thread " + this.getName() + " waited for " + ++count + " seconds");
            } catch (InterruptedException e) {
                System.out.println("Thread " + this.getName() + " interrupted");
            }
        }

        System.out.println("Thread " + this.getName() + " finished");
    }
}
