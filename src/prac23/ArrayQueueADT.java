package prac23;

import java.util.ArrayList;

public abstract class ArrayQueueADT<T> {
    protected int front, rear;
    protected int size;
    protected T items[];
    protected ArrayQueueADT(Class<T> dataType, int size){
        this.size = size;
        this.front = -1;
        this.rear = -1;
        this.items = (T[]) java.lang.reflect.Array.newInstance(dataType, size);
    }
    boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        return false;
    }
    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }
    void insertQueue(T element) {
        if (isFull()) {
            System.out.println("Queue is full");
        }
        else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            items[rear] = element;
            System.out.println("Insert " + element);
        }
    }

    T deleteElement() {
        T element;
        // if queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        else {
            element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            }
            else {
                front++;
            }
            System.out.println( element + "Deleted");
            return (element);
        }
    }
    void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        }
        else {
            System.out.println("\nFront index-> " +
                    front);
            System.out.println("Items -> ");
            for (i = front; i <= rear; i++)
                System.out.print(items[i] + " ");
            System.out.println("\nRear index-> " + rear);
        }
    }
}
