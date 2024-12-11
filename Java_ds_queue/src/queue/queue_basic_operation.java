package queue;

class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    // Constructor to initialize the queue
    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    // Enqueue operation: adds an element to the rear of the queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
        } else {
            rear = (rear + 1) % maxSize; // Circular increment
            queueArray[rear] = value;
            currentSize++;
        }
    }

    // Dequeue operation: removes and returns the front element of the queue
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty. Cannot dequeue.");
        } else {
            int frontValue = queueArray[front];
            front = (front + 1) % maxSize; // Circular increment
            currentSize--;
            return frontValue;
        }
    }

    // Peek operation: returns the front element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty. Cannot peek.");
        } else {
            return queueArray[front];
        }
    }

    // isEmpty operation: checks if the queue is empty
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    // isFull operation: checks if the queue is full
    public boolean isFull() {
        return (currentSize == maxSize);
    }

    // Size operation: returns the current size of the queue
    public int size() {
        return currentSize;
    }

    // Display operation: prints all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue elements: ");
            for (int i = 0; i < currentSize; i++) {
                int index = (front + i) % maxSize;
                System.out.print(queueArray[index] + " ");
            }
            System.out.println();
        }
    }
}

// Testing the Queue
public class queue_basic_operation {
    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue after enqueuing elements:");
        queue.display();

        System.out.println("Peek front element: " + queue.peek());

        System.out.println("Dequeue front element: " + queue.dequeue());

        System.out.println("Queue after dequeuing an element:");
        queue.display();

        System.out.println("Is queue empty? " + queue.isEmpty());

        System.out.println("Is queue full? " + queue.isFull());

        System.out.println("Current size of queue: " + queue.size());
    }
}

