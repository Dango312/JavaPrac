package prac23;

public class QueueTester {
    public static void main(String[] args) {
        int size = 10;
        ArrayQueueModule q = new ArrayQueueModule(size);
        q.deleteElement();
        for(int i = 1; i < size; i ++) {
            q.insertQueue("String" + i);
        }
        q.insertQueue("STRING");
        q.display();
        q.deleteElement();
        q.display();
    }
}
