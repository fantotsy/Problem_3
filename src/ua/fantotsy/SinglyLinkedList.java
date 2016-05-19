package ua.fantotsy;

public class SinglyLinkedList {
    private Node first;
    private Node last;

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void addFront(int element) {
        Node node = new Node(element);
        if (first != null) {
            node.next = first;
        } else {
            last = node;
        }
        first = node;
    }

    public void addBack(int element) {
        Node node = new Node(element);
        if (last != null) {
            last.next = node;
        } else {
            first = node;
        }
        last = node;
    }

    public void deleteElement(int element) {
        if (first == null) {
            return;
        }
        if (first == last) {
            if (first.data == element) {
                first = null;
                last = null;
                return;
            } else {
                return;
            }
        }
        Node current = first;
        if (current.data == element) {
            first = current.next;
        }
        while (current.next != null) {
            if (current.next.data == element) {
                current.next = current.next.next;
                if (current.next == null) {
                    last = current;
                }
            }
            if (current != last) {
                current = current.next;
            }
        }
    }

    public int size() {
        Node current = first;
        int result = 0;
        while (current != null) {
            result++;
            current = current.next;
        }
        return result;
    }

    public void printList() {
        if (size() == 0) {
            System.out.println("This list is empty.");
            return;
        }
        System.out.println("-Start-");
        Node current = first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("-End-");
    }
}
