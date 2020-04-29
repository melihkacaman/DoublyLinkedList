package QueueWithLinkedList;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> kuyruk = new Queue<>();

        kuyruk.enqueue(5);
        kuyruk.enqueue(3);
        kuyruk.enqueue(7);
        System.out.println("Size:" + kuyruk.size());

        kuyruk.print();


        kuyruk.dequeue();
        kuyruk.enqueue(kuyruk.dequeue());
        kuyruk.enqueue(kuyruk.dequeue());
        kuyruk.print();
    }
}
