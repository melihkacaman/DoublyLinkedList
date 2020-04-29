package HashTable_LinkedList;

public class Test {
    public static void main(String[] args) {
        HashTable<Integer, String> map = new HashTable<>(5);
        map.put(12, "Melih");
        map.put(24, "Kacaman");

        map.print();

        System.out.println("12:" + map.get(12));
    }
}
