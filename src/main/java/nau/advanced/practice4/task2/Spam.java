package nau.advanced.practice4.task2;

import java.util.Objects;
import java.util.Scanner;

public class Spam {
    private Thread[] threads;

    public Spam(String[] messages, int[] intervals) {
        threads = new Thread[messages.length];
        for (int i = 0; i < messages.length; i++) {
            threads[i] = new Worker(messages[i], intervals[i]);
        }
    }

    public void start() throws InterruptedException {
        for (var thread : threads) {
            thread.start();
        }
    }

    public void stop() {
        for (var thread : threads) {
            thread.stop();
        }
    }

    private static class Worker extends Thread {
        String message;
        int interval;

        public Worker(String message, int interval) {
            this.message = message;
            this.interval = interval;
        }

        @Override
        public void run() {
            try {
                sleep(interval);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(message);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String[] messages = new String[]{"First", "Second", "Third"};
        int[] intervals = new int[]{3000, 8000, 3500};
        Spam spam = new Spam(messages, intervals);
        spam.start();
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        if(Objects.equals(command, "")){
            spam.stop();
        }
    }
}
