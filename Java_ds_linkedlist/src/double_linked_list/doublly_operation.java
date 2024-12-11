package double_linked_list;
class DoublyLinkedList {

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

    public DoublyLinkedList() {
        this.head = null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
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
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }


    public void insertAtLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }


    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next != null) {
            head.next.prev = null;
        }
        head = head.next;
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
        for (int i = 1; i < position && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }


    public void deleteAtLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
    }


    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class doublly_operation {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtBeginning(10);
        dll.insertAtLast(20);
        dll.insertAtLast(30);
        dll.insertAtPosition(15, 2);

        System.out.println("List after insertion:");
        dll.display();

        dll.deleteAtBeginning();
        dll.deleteAtLast();
        dll.deleteAtPosition(2);

        System.out.println("List after deletion:");
        dll.display();
    }
}
