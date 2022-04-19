package nau.advanced.practice3.task2;

public class Node {
    Integer key;
    String value;
    Node next;

    public Node(Integer key, String value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Node(Integer key, String value) {
        this(key, value, null);
    }
}