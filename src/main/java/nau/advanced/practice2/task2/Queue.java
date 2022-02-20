package nau.advanced.practice2.task2;

import nau.advanced.practice1.Task2.Container;

public interface Queue extends Container {
    // Appends the specified element to the end.
    void enqueue(Object element);

    // Removes the head.
    Object dequeue();

    // Returns the head.
    Object top();
}
