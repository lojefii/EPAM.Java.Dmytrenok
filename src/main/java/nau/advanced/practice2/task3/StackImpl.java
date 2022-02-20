package nau.advanced.practice2.task3;

import nau.advanced.practice2.data.City;
import nau.advanced.practice2.data.CitySerialize;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {
    private Node first;

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        try {
            City[] cities = (City[]) CitySerialize.readFromXml(CitySerialize.pathXml);
            for (City city : cities) {
                stack.push(city);
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        System.out.println("\n\t\t\tStack:\n" + stack);

        System.out.println("\nPopped element: " + stack.pop());
        System.out.println("\nTop element: " + stack.top());
        System.out.println("\nSize of the stack = " + stack.size());

        var iterator = stack.iterator();
        while (iterator.hasNext()) {
            City city = (City) iterator.next();
            if (city.getName().equals("London")) {
                System.out.println("Lond was deleted");
                iterator.remove();
            }
        }

        System.out.println("\n\t\t\tStack:\n" + stack);

        try {
            CitySerialize.writeToJson(stack.iterator(), CitySerialize.pathJson);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        stack.clear();
        System.out.println("\n\t\t\tCleared stack: \n" + stack);
    }

    @Override
    public void push(Object node) {
        first = new Node(node, first);
    }

    @Override
    public Object pop() {
        if (first == null) {
            throw new NoSuchElementException("Stack is empty");
        }
        Object data = first.data;
        first = first.next;
        return data;
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
        string.append("[");
        Node current = first;
        while (current != null) {
            string.append(current.data);
            if (current.next != null) {
                string.append(", ");
            }
            current = current.next;
        }
        string.append("]");
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
                pop();
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
