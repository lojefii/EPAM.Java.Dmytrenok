package nau.advanced.practice3.task3.task2;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class SortedByAbsoluteValueIntegerSet implements Set<Integer> {
    private Node root;

    @Override
    public int size() {
        int size = 0;
        Node current = root;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(Object obj) {
        Node current = root;
        while (current != null) {
            if (current.data.equals(obj)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node node = new Node(null, root);

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    node = node.next;
                    return node.data;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    @Override
    public Object[] toArray() {
        Integer[] array = new Integer[size()];
        int index = 0;
        for(Integer val : this){
            array[index] = val;
            index++;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer number) {
        if (isEmpty()) {
            root = new Node(number);
            return true;
        }
        if (Math.abs(root.data) == Math.abs(number)) {
            return false;
        }
        if (Math.abs(root.data) > Math.abs(number)) {
            root = new Node(number, root);
            return true;
        }
        Node current = root;
        while (current.next != null) {
            if (Math.abs(current.next.data) == Math.abs(number)) {
                return false;
            }
            if (Math.abs(current.next.data) > Math.abs(number)) {
                current.next = new Node(number, current.next);
                return true;
            }
            current = current.next;
        }
        current.next = new Node(number);
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        if (isEmpty()) {
            throw new IllegalCallerException("Set is empty");
        }
        if (root.data.equals(obj)) {
            root = root.next;
            return true;
        }
        Node current = root;
        while (current.next != null) {
            if (current.next.data.equals(obj)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Integer search(Object obj) {
        Node current = root;
        while (current != null) {
            if (current.data.equals(obj))
                return current.data;
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        boolean added = false;
        for (Integer val : c) {
            added = add(val) || added;
        }
        return added;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removed = false;
        for (var val : c) {
            removed = remove(val) || removed;
        }
        return removed;
    }

    @Override
    public void clear() {
        root = null;
    }
}
