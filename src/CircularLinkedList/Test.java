package CircularLinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(new Node(5));
        list.addLast(10);
        list.addLast(15);
        list.addLast(20);
        list.remove(15);

        list.print();
    }
}
