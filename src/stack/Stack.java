package stack;

public class Stack<T> {
    private Node<T> head;

    void push(Node newNode){
        newNode.nextNode = head;
        head = newNode;
    }

    void push(T data) {
        push(new Node<>(data));
    }

    Node<T> pop(){
        if (isEmpty())
        {
            System.out.println("List is empty.");
            return null;
        }
        else {
            Node<T> removedNode = head;

            head = head.nextNode;
            return removedNode;
        }
    }

    Node<T> peek(){
        return head;
    }

    int size() {
        int counter = 0;
        Node<T> temp = head;

        while (temp != null) {
            counter++;
            temp = temp.nextNode;
        }

        return counter;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Empty stack !");
        } else {
            System.out.println("Stack elements are :");

            Node<T> temp = head;

            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.nextNode;
            }

            System.out.println("null");
        }
    }

    private boolean isEmpty(){
        return head == null;
    }
}
