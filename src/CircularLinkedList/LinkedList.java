package CircularLinkedList;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    void addFirst(Node<T> newNode) {
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.nextNode = head;
            head = newNode;
        }

        tail.nextNode = head;
        size++;
    }

    void addFirst(T data) {
        addFirst(new Node(data));
    }

    void addLast(Node<T> newNode) {
        if (isEmpty()) {
            addFirst(newNode);
        } else {
            tail.nextNode = newNode;
            newNode.nextNode = head;
            tail = newNode;

        }
        size++;
    }

    void addLast(T data) {
        addLast(new Node(data));
    }

    boolean addAfter(Node newNode, T data) {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return false;
        } else {
            Node temp = head;

            while (!temp.data.equals(data)) {
                temp = temp.nextNode;
                if (temp == head)
                    return false;
            }

            newNode.nextNode = temp.nextNode;
            temp.nextNode = newNode;

            if (temp == tail)
                tail = newNode;

            size++;
            return true;
        }
    }

    boolean addAfter(T data, T search) {
        return addAfter(new Node(data), search);
    }

    Node<T> remove(T data) {
        Node removedNode = null;
        if (isEmpty()) {
            System.out.println("List is empty !");
            return removedNode;
        } else {
            if (head.data.equals(data) && size == 1) {
                removedNode = head;
                head = null;
                tail = null;
                return removedNode;
            } else if (head.data.equals(data) && size != 1) {
                removedNode = head;
                head = head.nextNode;
                tail.nextNode = head;

                size--;

            } else {
                Node temp = head;

                for (int i = 0; i < size; i++) {

                    if (temp.nextNode.data.equals(data)) {
                        removedNode = temp.nextNode;

                        if (removedNode == tail)
                            tail = temp;

                        temp.nextNode = temp.nextNode.nextNode;
                        size--;

                    }

                    temp = temp.nextNode;
                }
            }
        }

        return removedNode;
    }

    private boolean isEmpty() {
        return head == null;
    }

    int size() {
        return size;
    }

    void print(){
        Node temp = head;
        for(int i = 0; i< size; i++) {
            System.out.print(temp.data + "-->");

            temp = temp.nextNode;
        }

        System.out.println("null");
    }
}
