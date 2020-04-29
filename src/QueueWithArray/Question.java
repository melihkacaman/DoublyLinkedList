package QueueWithArray;

public class Question {
    public static void main(String[] args) {
        fibonacciPoint(10);
        System.out.println(fibonacci(10));
    }

    static int fibonacci(int n){
        Queue<Integer> queue = new Queue<>(2);
        queue.enqueue(0);
        queue.enqueue(1);

        // 0 1 1 2 3 5 8
        for (int i=0; i<n; i++){
            int first = queue.dequeue();
            int second = queue.dequeue();

            queue.enqueue(second);
            queue.enqueue(first + second);
        }

        return queue.dequeue();
    }

    static void fibonacciPoint(int n){
        Queue<Integer> queue = new Queue<>(2);
        queue.enqueue(0);
        queue.enqueue(1);

        // 0 1 1 2 3 5 8
        for (int i=0; i<n; i++){
            int first = queue.dequeue();
            int second = queue.dequeue();

            System.out.print(first + " ");

            queue.enqueue(second);
            queue.enqueue(first + second);
        }
    }
}
