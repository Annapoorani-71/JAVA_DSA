package circular_double_linked_list;

class CircularDoublyLinkedList {
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public CircularDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
    }

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
            insertAtLast(data);
        } else {
            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
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
            head.prev = tail;
            tail.next = head;
        }
    }


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
        for (int i = 1; i < position && temp != tail; i++) {
            temp = temp.next;
        }

        if (temp == tail) {
            deleteAtLast();
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }


    public void deleteAtLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) { // Single node case
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
    }

  
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


public class circular_double_opration {
    public static void main(String[] args) {
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();

        cdll.insertAtBeginning(10);
        cdll.insertAtLast(20);
        cdll.insertAtLast(30);
        cdll.insertAtPosition(15, 2);

        System.out.println("List after insertion:");
        cdll.display();

        cdll.deleteAtBeginning();
        cdll.deleteAtLast();
        cdll.deleteAtPosition(2);

        System.out.println("List after deletion:");
        cdll.display();
    }
}

