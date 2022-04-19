package nau.advanced.practice3.task3.task1;

public class Node {

    String data;
    Node next;

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(String data) {
        this(data, null);
    }
}