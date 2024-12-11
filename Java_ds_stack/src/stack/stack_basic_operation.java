package stack;

import java.util.EmptyStackException;

class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor to initialize the stack
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Indicates an empty stack
    }

    // Push operation: adds an element to the top of the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
        } else {
            stackArray[++top] = value;
        }
    }

    // Pop operation: removes and returns the top element of the stack
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackArray[top--];
        }
    }

    // Peek operation: returns the top element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackArray[top];
        }
    }

    // isEmpty operation: checks if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // isFull operation: checks if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Size operation: returns the current size of the stack
    public int size() {
        return top + 1;
    }

    // Display operation: prints all elements in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
}

// Testing the Stack
public class stack_basic_operation {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack after pushing elements:");
        stack.display();

        System.out.println("Peek top element: " + stack.peek());

        System.out.println("Pop top element: " + stack.pop());

        System.out.println("Stack after popping an element:");
        stack.display();

        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.println("Is stack full? " + stack.isFull());

        System.out.println("Current size of stack: " + stack.size());
    }
}
