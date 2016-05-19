package ua.fantotsy;

public class DoublyLinkedList {
    private Header header = new Header();

    private static class Node {
        Node next;
        Node previous;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    private static class Header {
        Node first;
        Node last;
    }

    public void addFront(int element) {
        Node node = new Node(element);
        if (header.first != null) {
            node.next = header.first;
            header.first.previous = node;
        } else {
            header.last = node;
        }
        header.first = node;
    }

    public void addBack(int element) {
        Node node = new Node(element);
        if (header.last != null) {
            header.last.next = node;
            node.previous = header.last;
        } else {
            header.first = node;
        }
        header.last = node;
    }

    public void deleteElement(int element) {
        if (header.first == null) {
            return;
        }
        if (header.first == header.last) {
            if (header.first.data == element) {
                header.first = null;
                header.last = null;
                return;
            } else {
                return;
            }
        }
        Node current = header.last;
        if (current.data == element) {
            current.previous.next = null;
            header.last = current.previous;
        }
        while (current.previous != null) {
            if (current.previous.data == element) {
                if (current.previous.previous != null) {
                    current.previous.previous.next = current;
                }
                current.previous = current.previous.previous;
                if (current.previous == null) {
                    header.first = current;
                }
            }
            if (current != header.first) {
                current = current.previous;
            }
        }
    }

    public int size() {
        Node current = header.first;
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
        Node current = header.first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("-End-");
    }
}
