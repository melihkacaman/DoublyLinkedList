package QueueWithArray;

public class Queue<T> {
    private T[] dataArray;
    private int front, rear;
    private int size;

    public Queue(int capacity) {
        this.dataArray = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    void enqueue(T newData) {
        if (isFull())
            System.out.println("Queue is full, you can add anything.");
        else {
            dataArray[rear] = newData;
            rear++;

            if (rear % this.dataArray.length == 0)
                rear = 0;

            size++;
        }
    }

    T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        } else {
            T data = dataArray[front];
            front++;

            if (front % this.dataArray.length == 0)
                this.front = 0;

            size--;
            return data;
        }
    }

    private boolean isEmpty() {
        return this.size == 0;
    }


    private boolean isFull() {
        return this.size == this.dataArray.length;
    }

    public int size(){
        return this.size;
    }

    void print(){
        int index = front;
        for (int i=0; i<size; i++) {
            System.out.print(dataArray[index] + "-->");

            if (index % this.dataArray.length== 0)
                index = 0;

            index++;
        }
        System.out.println("");
    }
}
