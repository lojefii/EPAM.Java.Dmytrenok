package nau.advanced.practice6.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

public class Iterators {
    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array) {
        return Arrays.stream(array).flatMap(value -> IntStream.of(value, value)).iterator();
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {
        return Arrays.stream(array).flatMap(value -> IntStream.of(value, value, value)).iterator();
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        return Arrays.stream(array).flatMap(value -> IntStream.of(value, value, value, value, value)).iterator();
    }

    public static Iterable<String> table(String[] columns, int[] rows) {
        Iterator<String> iterator = new Iterator<>() {
            int indexColumns = 0;
            int indexRows = 0;

            @Override
            public boolean hasNext() {
                return indexColumns < columns.length;
            }

            @Override
            public String next() {
                String result = columns[indexColumns] + rows[indexRows];
                indexRows++;
                if(indexRows == rows.length){
                    indexColumns++;
                    indexRows = 0;
                }
                return result;
            }
        };
        return (Iterable<String>) iterator;
    }
}
