package circular_single_linked_list;

class CircularSinglyLinkedList {
    // Node of a circular singly linked list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public CircularSinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Insertion at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    // Insertion at a specific position (1-based index)
    public void insertAtPosition(int data, int position) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        Node newNode = new Node(data);

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp != tail; i++) {
            temp = temp.next;
        }

        if (temp == tail) {
            System.out.println("Position out of bounds, inserting at last.");
            insertAtLast(data);
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Insertion at the end
    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Deletion at the beginning
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) { // Single node case
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }

    // Deletion at a specific position (1-based index)
    public void deleteAtPosition(int position) {
        if (head == null || position <= 0) {
            System.out.println("Invalid position or list is empty");
            return;
        }

        if (position == 1) {
            deleteAtBeginning();
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != tail.next; i++) {
            temp = temp.next;
        }

        if (temp.next == tail.next) {
            System.out.println("Position out of bounds");
            return;
        }

        if (temp.next == tail) {
            tail = temp;
            tail.next = head;
        } else {
            temp.next = temp.next.next;
        }
    }

    // Deletion at the end
    public void deleteAtLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) { // Single node case
            head = null;
            tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = head;
        }
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}


public class circular_operation {
    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

        csll.insertAtBeginning(10);
        csll.insertAtLast(20);
        csll.insertAtLast(30);
        csll.insertAtPosition(15, 2);

        System.out.println("List after insertion:");
        csll.display();

        csll.deleteAtBeginning();
        csll.deleteAtLast();
        csll.deleteAtPosition(2);

        System.out.println("List after deletion:");
        csll.display();
    }
}

