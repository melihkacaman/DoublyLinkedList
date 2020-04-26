package DoublyLinkedList;

public class LinkedList<T> {
    private Node<T> head;
    private int size = 0;

    void addFirst(Node<T> newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.nextNode = head;
            head.prevNode = newNode;

            head = newNode;
        }
        size++;
    }

    void addFirst(T data) {
        addFirst(new Node<>(data));
    }

    void addLast(Node<T> newNode) {
        if (isEmpty()) {
            addFirst(newNode);
        } else {
            Node<T> temp = head;

            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }

            newNode.prevNode = temp;
            temp.nextNode = newNode;
            newNode.nextNode = null;
            size++;
        }
    }

    void addLast(T data) {
        addLast(new Node<>(data));
    }

    boolean addAfter(Node<T> newNode, T data) {
        if (isEmpty()) {
            System.out.println("List is empty !");
            return false;
        } else {
            Node<T> temp = head;

            while (temp != null && !temp.data.equals(data))
                temp = temp.nextNode;

            if (temp != null) {
                newNode.nextNode = temp.nextNode;
                newNode.prevNode = temp;
                if (temp.nextNode != null) {
                    temp.nextNode.prevNode = newNode;
                }
                temp.nextNode = newNode;

                size++;

                return true;
            } else {
                System.out.println("The data hasn't been found. ");
                return false;
            }
        }
    }

    boolean addAfter(T newData, T data) {
        return addAfter(new Node<T>(newData), data);
    }

    Node<T> remove(T data) {
        Node<T> removedNode = null;

        if (isEmpty()) {
            System.out.println("List is empty !");
            return removedNode;
        } else {
            Node temp = head;

            while (temp != null && !temp.data.equals(data))
                temp = temp.nextNode;

            if (temp != null) {
                size--;
                removedNode = temp;

                temp.prevNode.nextNode = temp.nextNode;
                if (temp.nextNode != null)
                    temp.nextNode.prevNode = temp.prevNode;

                return removedNode;

            } else {
                System.out.println("The data hasn't been found!");
                return removedNode;
            }
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    void print() {
        Node<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.nextNode;
        }

        System.out.println("null");
    }
}
