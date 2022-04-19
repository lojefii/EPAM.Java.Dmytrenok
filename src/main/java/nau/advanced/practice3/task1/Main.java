package nau.advanced.practice3.task1;

public class Main {
    public static void main(String[] args) {
        RangedOpsIntegerSet intSet = new RangedOpsIntegerSet();
        intSet.add(1);
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);
        intSet.add(5);
        print("After adding numbers one by one: ", intSet);

        intSet.remove(2);
        print("\nAfter removing one number: ", intSet);

        intSet.add(1, 6);
        intSet.add(9, 13);
        print("\n\nAfter adding a range of numbers: " ,intSet);

        intSet.remove(3);
        print("\nAfter removing one number: ", intSet);

        intSet.remove(4, 9);
        print("\nAfter removing a range of numbers: ", intSet);
    }

    public static void print(String message, RangedOpsIntegerSet intSet) {
        System.out.print(message);
        for (Integer number : intSet) {
            System.out.print(number + " ");
        }
    }
}
