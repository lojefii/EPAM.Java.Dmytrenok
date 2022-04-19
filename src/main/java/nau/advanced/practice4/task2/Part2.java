package nau.advanced.practice4.task2;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Part2 {
    public static void main(String[] args) throws InterruptedException {
        InputStream thread = System.in;
        System.setIn(new MyInputStream());

        Thread spamThread = new Thread(){
            public void run(){
                try {
                    Spam.main(null);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        spamThread.start();
        spamThread.join();
        System.setIn(thread);
    }

    private static class MyInputStream extends InputStream {
        boolean start = true;
        @Override
        public int read(){
            int index = -1;
            if(start)
                try {
                    Thread.sleep(2000);
                    start = false;
                    index = "\n".getBytes(StandardCharsets.UTF_8)[0];
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            return index;
        }
    }
}
