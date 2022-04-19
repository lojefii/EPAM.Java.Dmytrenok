package nau.advanced.practice4.task1;

public class Part1 {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 6; i++) {
                System.out.println("\t" + getName());
                try {
                    sleep(1000 / 3);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 6; i++) {
                System.out.println("\t" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000 / 3);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread: ");
        Thread thread = new MyThread();
        thread.start();
        thread.join();

        System.out.println("\nRunnable: ");
        Thread runnable = new Thread(new MyRunnable());
        runnable.start();
        runnable.join();
    }
}