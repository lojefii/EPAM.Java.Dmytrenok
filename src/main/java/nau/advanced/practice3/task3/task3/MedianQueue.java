package nau.advanced.practice3.task3.task3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MedianQueue implements Iterable<Integer> {
    private Node root;

    public void offer(Integer number) {
        if (root == null) {
            root = new Node(number);
        } else {
            Node last = root;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Node(number);
        }
    }

    public Integer poll() {
        if (root == null) {
            throw new IllegalCallerException("Queue is empty");
        }
        Integer rootData = root.data;
        root = root.next;
        return rootData;
    }

    public Integer peek() {
        return root.data;
    }

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

    public int size() {
        int size = 0;
        Node current = root;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public Integer median() {
        Integer[] array = toArray();
        Arrays.sort(array);
        int median = (size() - 1) / 2;
        return array[median];
    }

    public Integer[] toArray() {
        Integer[] array = new Integer[size()];
        int index = 0;
        for(Integer val : this){
            array[index] = val;
            index++;
        }
        return array;
    }
}
