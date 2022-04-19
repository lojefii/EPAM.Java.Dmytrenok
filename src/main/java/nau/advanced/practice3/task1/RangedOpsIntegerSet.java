package nau.advanced.practice3.task1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangedOpsIntegerSet implements Iterable<Integer> {
    private Node root;
    private final IteratorImpl iterator = (IteratorImpl) iterator();

    public boolean add(Integer number) {
        if (root == null) {
            root = new Node(number);
            return true;
        }
        Node last = root;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new Node(number);
        return true;
    }

    public boolean remove(Integer element) {
        if (root == null) {
            throw new IllegalCallerException("Integer set is empty");
        }
        if (root.data.equals(element)) {
            root = root.next;
            return true;
        }
        Node current = root;
        while (current.next != null) {
            if (current.next.data.equals(element)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    boolean add(int inclusive, int exclusive) {
        iterator.reset();
        if(root == null) {
            root = new Node(inclusive++);
            iterator.reset();
        }

        while ( iterator.current != null && iterator.hasNext()) {
            iterator.next();
        }
        int count = exclusive - inclusive - 1;
        while(count >= 0) {
            count--;
            iterator.current.next = new Node(inclusive++);
            iterator.next();
        }
        return true;
    }

    boolean remove(int inclusive, int exclusive) {
        iterator.reset();
        while(iterator.hasNext() && iterator.current.data != inclusive) {
            iterator.next();
        }
        while(iterator.current.data != exclusive && iterator.hasNext()  ) {
            iterator.remove();
            iterator.next();
        }
        return true;
    }

    int size() {
        int size = 0;
        while (iterator.current != null) {
            iterator.next();
            size++;
        }
        return size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }

    class IteratorImpl implements Iterator<Integer> {
        private Node current;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                current = current.next;
                return current.data;
            } else {
                throw new NoSuchElementException();
            }
        }

        public IteratorImpl() {
            reset();
        }

        public void reset() {
            current = root;
        }

        public Node getCurrent() {
            return current;
        }

        public Object getCurrentData() {
            return current.data;
        }

        @Override
        public void remove() {
            Node previous = root;
            IteratorImpl iterator = new IteratorImpl();
            while (iterator.hasNext()) {
                if (iterator.current.next.equals(current)) {
                    previous = iterator.current;
                    previous.next = current.next;
                    return;
                }
                iterator.next();
            }
        }
    }
}