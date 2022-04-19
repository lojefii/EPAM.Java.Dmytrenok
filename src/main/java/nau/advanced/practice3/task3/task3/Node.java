package nau.advanced.practice3.task3.task3;

public class Node {
    Integer data;
    Node next;

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(Integer data) {
        this(data, null);
    }
}