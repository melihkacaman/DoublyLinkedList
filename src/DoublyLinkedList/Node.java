package DoublyLinkedList;

public class Node<T> {
    T data;
    Node<T> nextNode;
    Node<T> prevNode;

    public Node(T data) {
        this.data = data;
        this.nextNode = null;
        this.prevNode = null;
    }
}
