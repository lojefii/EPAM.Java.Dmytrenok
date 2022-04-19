package nau.advanced.practice4.task3;

public class Part3 {
    private int counter1 = 0;
    private int counter2 = 0;

    public void compare() {
        System.out.println(counter1 > counter2 ? "First > Second" : "Second > First");
        counter1++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        counter2++;
    }

    synchronized public void compareSync() {
        compare();
    }

    private static void runNonSync(int threadNumber) throws InterruptedException {
        Part3 counter = new Part3();
        Thread[] threads = new Thread[threadNumber];
        for (int i = 0; i < threadNumber; i++) {
            threads[i] = new Thread(counter::compare);
        }
        for (int i = 0; i < threadNumber; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threadNumber; i++) {
            threads[i].join();
        }
    }

    private static void runSync(int threadNumber) throws InterruptedException {
        Part3 counter = new Part3();
        Thread[] threads = new Thread[threadNumber];
        for (int i = 0; i < threadNumber; i++) {
            threads[i] = new Thread(counter::compareSync);
        }
        for (int i = 0; i < threadNumber; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threadNumber; i++) {
            threads[i].join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 5;
        System.out.println("NonSynchronized");
        runNonSync(threadCount);

        System.out.println("Synchronized");
        runSync(threadCount);
    }
}
