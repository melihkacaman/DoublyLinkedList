package Heap;

public class MinHeap<T extends Comparable<T>> {
    private T[] heap;
    private int size = 0;

    public MinHeap(int capacity) {
        this.heap = (T[])new Comparable[capacity];
        this.size = 0;
    }

    private int parent(int k){
        return (k-1)/ 2;
    }

    void insert(T newData){
        if(this.size < this.heap.length){
            heap[size] = newData;
            int current = size++;

            while (heap[current].compareTo(heap[parent(current)]) < 0 ){
                swap(current, parent(current));
                current = parent(current);
            }
        }else {
            System.out.println("heap is full!");
        }
    }

    private void swap(int current, int parent) {
        T temp = heap[current];
        heap[current] = heap[parent];
        heap[parent] = temp;
    }

    void heapify(){
        int lastIndex = size - 1;

        for (int i = parent(lastIndex); i>= 0; i--){
            minHeap(i);
        }
    }

    private void minHeap(int i) {
        int left = 2*i + 1;
        int right = 2*i + 2;

        int min = i;

        if (left < size && heap[min].compareTo(heap[left]) > 0){
            min = left;
        }
        if (right < size && heap[min].compareTo(heap[right]) > 0){
            min = right;
        }

        if (min != i){
            swap(min, i);
            minHeap(min);
        }
    }

    T deleteMin(){
        T deletedMin = heap[0];
        heap[0] = heap[size - 1];
        size--;

        //heapify();
        minHeap(0);
        return deletedMin;
    }

    void printArray(){
        for (T element: heap){
            System.out.print(element + "-->");
        }
        System.out.println();
    }

    void print(){
        for (int i = 0; i <= size / 2; i++) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int seviye = (int) (Math.log(i+1) / Math.log(2));
            System.out.print(seviye+".Seviye PARENT : " + heap[i]);

            if (left < size){
                System.out.print(" LEFT CHILD : " + heap[left]);
            }
            else {
                break;
            }
            if (right < size){
                System.out.println(" RIGHT CHILD :" + heap[right]);
            }else
            {
                break;
            }

            System.out.println();
        }

    }

    void decreaseKey(int key, int amount){
        for (int i=0; i< size; i++){
            if (heap[i].equals(key)) {
                heap[i] = (T)new Integer(key - amount);

                while (heap[i].compareTo(heap[parent(i)]) < 0) {
                    swap(i,parent(i));
                    i = parent(i);
                }
                break;
            }
        }
    }

    void increaseKey(int key, int amount){
        for (int i=0; i< size; i++){
            if (heap[i].equals(key)) {
                heap[i] = (T)new Integer(key + amount);

                minHeap(i);
                break;
            }
        }
    }
}
