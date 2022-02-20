package nau.advanced.practice1.Task2;

import java.util.Iterator;

public class ArrayImpl implements Array {
    int lastElement;
    Object[] array;

    public ArrayImpl(int size) {
        if (size <= 0)
            size = 1;
        array = new Object[size];
    }

    @Override
    public void add(Object element) {
        set(lastElement, element);
    }

    @Override
    public void set(int index, Object element) {
        if(isFull())
            throw new ArrayIndexOutOfBoundsException();
        if(index < 0 || index > lastElement)
            throw new ArrayIndexOutOfBoundsException();;

        System.arraycopy(array, index, array, index + 1, array.length - 1 - index);
        array[index] = element;
        lastElement++;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= lastElement)
            throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public int indexOf(Object element) {
        Iterator<Object> iterator = iterator();
        int index = 0;
        while (iterator.hasNext()) {
            if (iterator.next().equals(element))
                return index;
            index++;
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException();;
        if (index < 0 || index >= lastElement)
            throw new ArrayIndexOutOfBoundsException();;

        Iterator<Object> iterator = iterator();
        while (index > 0) {
            iterator.next();
            index--;
        }
        iterator.remove();
        lastElement--;
    }

    @Override
    public void clear() {
        array = new Object[array.length];
        lastElement = 0;
    }

    @Override
    public int size() {
        return lastElement;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private boolean isEmpty() {
        return lastElement == 0;
    }

    private boolean isFull() {
        return lastElement >= array.length;
    }

    @Override
    public String toString() {
        Iterator<Object> iterator = iterator();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            if (iterator.hasNext()) stringBuilder.append(", ");

        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public class IteratorImpl implements Iterator {
        private int index;

        public IteratorImpl() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public Object next() {
            return get(index++);
        }

        @Override
        public void remove() {
            array[index] = null;
            for (int i = index; i < lastElement - 1; i++) {
                array[i] = array[i + 1];
                array[i + 1] = null;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("\n\tThe methods of the Array interface");
        ArrayImpl array = new ArrayImpl(10);
        System.out.print("\nArray: \n");
        array.add(1);
        array.add(3);
        array.add(5);
        System.out.println(array + "\n");

        System.out.print("Array with new values: \n");
        array.set(1, 2);
        array.set(3, 4);
        System.out.print(array + "\n");

        int index = 1;
        System.out.println("\nThe value at index " + index + " is " + array.get(index));

        int value = 3;
        System.out.println("\nThe index of value " + "'" + value + "' is " + array.indexOf(3));

        System.out.println("\nThe value '" + array.get(index) + "' at index " + index + " was removed");
        array.remove(index);
        System.out.print("\nArray after removing: \n");
        System.out.println(array + "\n");

        System.out.println("Array was cleared\n");
        array.clear();
        System.out.println("Array after clear: ");
        System.out.println(array + "\n");

        System.out.println("\n\tThe methods of the Iterator interface");

        System.out.println("\n\n\tIterator methods");
        array.add("1");
        array.add("2");
        array.add("3");

        System.out.print("\nArray: \n");
        IteratorImpl iterator = array.new IteratorImpl();
        System.out.print("[");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.print("]");

        System.out.println("\n\nArray after removing: ");

        iterator = array.new IteratorImpl();
        iterator.remove();

        System.out.print("[");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.print("]");
    }
}
