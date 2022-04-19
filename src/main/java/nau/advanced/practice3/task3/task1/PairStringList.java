package nau.advanced.practice3.task3.task1;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PairStringList implements Collection<String> {
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
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private Node node = new Node(null, root);

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public String next() {
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
        String[] array = new String[size()];
        int index = 0;
        for(String val : this){
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
    public boolean add(String str) {
        if (isEmpty()) {
            root = new Node(str, new Node(str));
        } else {
            Node last = root;
            while (last.next != null)
                last = last.next;
            last.next = new Node(str, new Node(str));
        }
        return true;
    }

    public boolean add(String str, int index) {
        if (index > size() || index < 0) {
            return false;
        }
        if(index == 0) {
            root = new Node(str, new Node(str, root));
            return true;
        }
        if(index % 2 == 1) {
            index++;
        }

        int currentIndex = 1;
        Node current = root;
        while (currentIndex != index) {
            current = current.next;
            currentIndex++;
        }
        current.next = new Node(str, new Node(str, current.next));
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        if (isEmpty()) {
            throw new IllegalCallerException("List is empty");
        }
        if (root.data.equals(obj)) {
            root = root.next.next;
            return true;
        }

        Node current = root;
        while (current.next != null) {
            if (current.next.data.equals(obj)) {
                current.next = current.next.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean remove(int index){
        if (index >= size() || index < 0) {
            return false;
        }
        if(index < 2){
            root = root.next.next;
            return true;
        }
        if(index % 2 == 1) {
            index--;
        }

        int currentIndex = 1;
        Node current = root;
        while (currentIndex != index) {
            current = current.next;
            currentIndex++;
        }
        current.next = current.next.next.next;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        boolean added = false;
        for (String val : c) {
            added = add(val) || added;
        }
        return added;
    }

    public boolean addAll(Collection<? extends String> c, int index) {
        boolean added = false;
        for(String val : c){
            add(val, index);
            index += 2;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> list) {
        boolean removed = false;
        for (var val : list) {
            removed = remove(val) || removed;
        }
        return removed;
    }

    public boolean removeAll(Collection<?> list, int index) {
        boolean removed = false;
        for (var val : list) {
            removed = remove(index) || removed;
        }
        return removed;
    }

    public String get(int index){
        if(index >= size() || index < 0){
            return null;
        }
        int currentIndex = 0;
        Node current = root;
        while (currentIndex != index){
            current = current.next;
            currentIndex++;
        }
        return current.data;
    }

    public boolean set(int index, String str){
        if(index >= size() || index < 0){
            return false;
        }
        if(index == 0){
            root.data = str;
            root.next.data = str;
            return true;
        }
        if(index % 2 == 1) {
            index--;
        }

        int currentIndex = 0;
        Node current = root;
        while (currentIndex != index) {
            current = current.next;
            currentIndex++;
        }
        current.data = str;
        current.next.data = str;
        return true;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }
}