package QueueWithLinkedList;

public class Queue<T> {
    private Node<T> front, rear;
    private int size = 0;
    void enqueue(T newData){
        Node<T> newNode = new Node<>(newData);
        if (isEmpty()){
            this.front = this.rear = newNode;
        }
        else {
            this.rear.nextNode = newNode;
            this.rear = newNode;
        }
        size++;
    }

    T dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty.");
            return null;
        }
        else {
            Node<T> temp = this.front;
            this.front = front.nextNode;
            size--;

            if (isEmpty())
                rear = null;

            return (T)temp.data;
        }
    }

    public int size(){
        return size;
    }

    void print(){
        Node temp = front;

        while (temp != null){
            System.out.print(temp.data.toString() + "-->");
            temp = temp.nextNode;
        }

        System.out.println("null");
    }

    private boolean isEmpty(){
        return front == null;
    }
}
