package DoublyLinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);

        list.addLast(2);
        list.addAfter(10,1);
        list.print();
    }
}
