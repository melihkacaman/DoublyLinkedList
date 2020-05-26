package Heap;

public class Test {
    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>(10);
        minHeap.insert(17);
        minHeap.insert(5);
        minHeap.insert(3);


        minHeap.printArray();
        minHeap.print();
    }
}
