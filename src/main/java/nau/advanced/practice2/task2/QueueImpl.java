package nau.advanced.practice2.task2;

import nau.advanced.practice2.data.City;
import nau.advanced.practice2.data.CitySerialize;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {
    private Node first;

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        try {
            City[] cities = (City[]) CitySerialize.readFromXml(CitySerialize.pathXml);
            for (City city : cities) {
                queue.enqueue(city);
            }
        } catch (Exception ex) {
            ex.getMessage();
        }

        System.out.println("\n\t\t\tQueue:\n" + queue);
        System.out.println("\nDequeued element: " + queue.dequeue());
        System.out.println("\nTop element: " + queue.top());
        System.out.println("\nSize of the queue = " + queue.size());

        var iterator = queue.iterator();
        while (iterator.hasNext()) {
            City city = (City) iterator.next();
            if (city.getName().equals("London")) {
                System.out.println("London was deleted");
                iterator.remove();
            }
        }

        System.out.println("\n\t\t\tQueue:\n" + queue);

        try {
            CitySerialize.writeToJson(queue.iterator(), CitySerialize.pathJson);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        queue.clear();
        System.out.println("\n\t\t\tCleared queue: \n" + queue);
    }

    @Override
    public void enqueue(Object node) {
        if (first == null) {
            first = new Node(node);
        } else {
            Node last = first;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Node(node);
        }
    }

    @Override
    public Object dequeue() {
        if (first == null)
            throw new NoSuchElementException("Queue is empty");
        Object head = first.data;
        first = first.next;
        return head;
    }

    @Override
    public Object top() {
        return first.data;
    }

    @Override
    public void clear() {
        first = null;
    }

    @Override
    public int size() {
        int size = 0;
        Node current = first;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("<-");
        Node current = first;
        while (current != null) {
            string.append(current.data);
            if (current.next != null) {
                string.append(", ");
            }
            current = current.next;
        }
        string.append(" <-");
        return string.toString();
    }

    private class IteratorImpl implements Iterator<Object> {
        private Node node = new Node(null, first);

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                node = node.next;
                return node.data;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            if (node.data.equals(first.data)) {
                QueueImpl.this.dequeue();
            }
            Node current = first;
            while (current.next != null) {
                if (current.next.data.equals(node.data)) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }
    }

    private static class Node {
        Object data;
        Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }
}
