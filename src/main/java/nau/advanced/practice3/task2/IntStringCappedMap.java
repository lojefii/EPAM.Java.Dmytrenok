package nau.advanced.practice3.task2;

import java.util.*;

public class IntStringCappedMap implements Map<Integer, String> {
    private int capacity;
    private Node root;

    public IntStringCappedMap(int capacity) {
        this.capacity = capacity;
    }

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
    public boolean containsKey(Object key) {
        Node current = root;
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Node current = root;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String get(Object key) {
        Node current = root;
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public String put(Integer key, String value) {
        if (value.length() > capacity) {
            throw new IllegalArgumentException();
        }
        if (get(key) != null) {
            return null;
        }
        if (root == null) {
            root = new Node(key, value);
            return root.value;
        } else {
            while (capacityProperty() + value.length() > capacity) {
                root = root.next;
            }
            Node last = root;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Node(key, value);
            return last.next.value;
        }
    }

    public int capacityProperty() {
        int property = 0;
        Node current = root;
        while (current != null) {
            property += current.value.length();
            current = current.next;
        }
        return property;
    }

    @Override
    public String remove(Object key) {
        if (get(key) == null) {
            return null;
        }
        Node current = root;
        if (root.key == key) {
            String rootValue = root.value;
            root = root.next;
            return rootValue;
        }
        while (current.next != null) {
            if (current.next.key == key) {
                String currentValue = current.next.value;
                current.next = current.next.next;
                return currentValue;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends String> map) {
        for(var val : map.entrySet()){
            put(val.getKey(), val.getValue());
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Set<Entry<Integer, String>> entrySet() {
        return new TreeSet<>() {
            @Override
            public Iterator<Entry<Integer, String>> iterator() {
                return new Iterator<>() {
                    private Node node = new Node(null, null, root);

                    @Override
                    public boolean hasNext() {
                        return node.next != null;
                    }

                    @Override
                    public Entry<Integer, String> next() {
                        if (hasNext()) {
                            node = node.next;
                            return new Entry<>() {
                                @Override
                                public Integer getKey() {
                                    return node.key;
                                }

                                @Override
                                public String getValue() {
                                    return node.value;
                                }

                                @Override
                                public String setValue(String value) {
                                    return node.value = value;
                                }
                            };
                        } else {
                            throw new NoSuchElementException();
                        }
                    }
                };
            }

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
        };
    }

    @Override
    public Set<Integer> keySet() {
        return null;
    }

    @Override
    public Collection<String> values() {
        return null;
    }
}
