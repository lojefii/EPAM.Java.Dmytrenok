package nau.advanced.practice2.task1;

import nau.advanced.practice2.data.City;
import nau.advanced.practice2.data.CitySerialize;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static nau.advanced.practice2.data.CitySerialize.*;

public class ListImpl implements List {
    private Node first;

    public static void main(String[] args) throws IOException {
        ListImpl list = new ListImpl();
        try {
            writeToXml(cities, pathXml);
            City[] cities = (City[]) CitySerialize.readFromXml(pathXml);
            for (City city : cities) {
                list.addFirst(city);
            }
        } catch (Exception ex) {
            ex.getMessage();
        }

        System.out.println("\n\t\t\tList:\n" + list);
        System.out.println("\nFirst element: " + list.getFirst());
        System.out.println("\nLast element: " + list.getLast());
        System.out.println("\nSize of the list = " + list.size());

        list.addLast(new City("Paris", "France", "2161000"));
        System.out.println("\n\t\t\tList after adding last element:\n" + list);

        list.removeFirst();
        System.out.println("\n\t\t\tList after removing first element:\n" + list);

        list.removeLast();
        System.out.println("\n\t\t\tList after removing last element:\n" + list);


        City paris = new City("Paris", "France", "2161000");
        City madrid = new City("Madrid", "Spain", "3223000");
        list.addFirst(paris);
        list.addFirst(madrid);
        System.out.println("\n\t\t\tList after adding two elements:\n" + list);

        System.out.println("Madrid was found - " + list.search(madrid));

        list.remove(paris);
        System.out.println("\n\t\t\tList after removing Paris:\n" + list);

        var iterator = list.iterator();
        while (iterator.hasNext()) {
            City city = (City) iterator.next();
            if (city.getName().equals("Kyiv")) {
                iterator.remove();
                System.out.println("\n\t\t\tList after removing Kyiv:\n" + list);
            }
        }

        try {
            CitySerialize.writeToJson(list.iterator(), CitySerialize.pathJson);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        list.clear();
        System.out.println("\n\t\t\tCleared list: \n" + list);
    }

    @Override
    public void addFirst(Object node) {
        if (first == null) {
            first = new Node(node);
        } else {
            first = new Node(node, first);
        }
    }

    @Override
    public void addLast(Object node) {
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
    public void removeFirst() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        first = first.next;
    }

    @Override
    public void removeLast() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        } else if (first.next == null) {
            first = null;
        } else {
            Node penultimate = first;
            while (penultimate.next.next != null) {
                penultimate = penultimate.next;
            }
            penultimate.next = null;
        }
    }

    @Override
    public Object getFirst() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        return first.data;
    }

    @Override
    public Object getLast() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        Node last = first;
        while (last.next != null) {
            last = last.next;
        }
        return last.data;
    }

    @Override
    public Object search(Object node) {
        Node current = first;
        while (current != null) {
            if (current.data.equals(node)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean remove(Object node) {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        Node current = first;
        while (current.next != null) {
            if (current.next.data.equals(node)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
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
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("(");
        Node current = first;
        while (current != null) {
            string.append(current.data);
            if (current.next != null) {
                string.append(", ");
            }
            current = current.next;
        }
        string.append("\n)");
        return string.toString();
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
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
            ListImpl.this.remove(node.data);
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
