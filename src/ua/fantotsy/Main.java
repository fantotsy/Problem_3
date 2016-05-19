package ua.fantotsy;

public class Main {

    public static void main(String[] args) {
        SinglyLinkedList sList = new SinglyLinkedList();
        sList.addFront(5);
        sList.addBack(7);
        sList.addFront(3);
        sList.addBack(4);
        sList.printList();
        sList.deleteElement(4);
        sList.printList();

        DoublyLinkedList dList = new DoublyLinkedList();
        dList.addFront(5);
        dList.addBack(7);
        dList.addFront(3);
        dList.addBack(4);
        dList.printList();
        dList.deleteElement(4);
        dList.deleteElement(3);
        dList.deleteElement(5);
        dList.deleteElement(7);
        dList.printList();
    }
}
