package nau.advanced.practice3.task3.task3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MedianQueue queue = new MedianQueue();
        queue.offer(2);
        queue.offer(13);
        queue.offer(47);
        queue.offer(122);
        queue.offer(402);
        queue.offer(15);
        queue.offer(615);
        queue.offer(983);
        System.out.print(Arrays.toString(queue.toArray()) + " -> ");
        System.out.println(queue.median());

        System.out.println("Top element - " + queue.peek() + "\n");

        queue.poll();
        System.out.print(Arrays.toString(queue.toArray()) + " -> ");
        System.out.println(queue.median());

        System.out.println("Top element - " + queue.peek());
    }
}
