package HashTable_LinkedList;

public class HashTable<K,V> {
    private LinkedList<K,V>[] table;

    public HashTable(int size) {
        this.table = new LinkedList[size];

        for(int i=0; i<size; i++){
            table[i] = new LinkedList<>();
        }
    }

    void put(K key, V value){
        int hashRes = hashFunction(key);
        int index = hashRes % table.length;

        Node temp = table[index].head;

        while (temp != null && !temp.key.equals(key))
            temp = temp.nextNode;

        if (temp == null)
            table[index].addFirst(key,value);
        else
            temp.value = value;
    }

    V get(K key){
        int hashRes = hashFunction(key);
        int index = hashRes % table.length;

        Node temp = table[index].head;

        while (temp != null && !temp.key.equals(key))
            temp = temp.nextNode;

        if (temp != null)
            return (V) temp.value;
        else
            System.out.println("doesn't exist");
        return null;
    }

    void print() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("[" + i + "]");
            table[i].print();
        }
    }

    private int hashFunction(K key) {
        return 0;
    }
}
