package queue;

public class CircularQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueArray;
    private int nItems;

    // Constructor to initialize the circular queue
    public CircularQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        nItems++;
        System.out.println("Enqueued: " + value);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int temp = queueArray[front];
        front = (front + 1) % maxSize;
        nItems--;
        System.out.println("Dequeued: " + temp);
        return temp;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
        return queueArray[front];
    }
    public boolean isEmpty() {
        return (nItems == 0);
    }
    public boolean isFull() {
        return (nItems == maxSize);
    }
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        int i = front;
        for (int count = 0; count < nItems; count++) {
            System.out.print(queueArray[i] + " ");
            i = (i + 1) % maxSize;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.printQueue();
        queue.enqueue(60);

      
        System.out.println("Front element is: " + queue.peek());

        System.out.println("Dequeued element is: " + queue.dequeue());
        queue.printQueue();

        System.out.println("Dequeued element is: " + queue.dequeue());
        queue.printQueue();

        System.out.println("Front element is: " + queue.peek());

     
        while (!queue.isEmpty()) {
            System.out.println("Dequeued element is: " + queue.dequeue());
        }
        System.out.println("Dequeued element is: " + queue.dequeue());

        // Test peek operation when queue is empty
        System.out.println("Front element is: " + queue.peek());
    }
}
