package HashTable_Array;

public class HashTable<K, V> {
    private HashEntry<K, V>[] table;

    public HashTable(int capasity) {
        this.table = new HashEntry[capasity];
    }

    void put(K key, V value) {
        int hashRes = hashFunction(key);
        int index = hashRes % table.length;

        if (table[index] == null) {
            table[index] = new HashEntry<>(key, value);
        } else if (table[index].key == key) {
            table[index].value = value;
        } else {
            int tempIndex = (index + 1) % table.length;

            while (tempIndex != index) {
                if (table[tempIndex] == null) {
                    table[tempIndex] = new HashEntry<>(key, value);
                    return;
                } else if (table[tempIndex].key == key) {
                    table[tempIndex].value = value;
                    return;
                }
                tempIndex = (tempIndex + 1) % table.length;
            }
            System.out.println("Can't be added.");
        }

    }

    V get(K key) {
        int hashRes = hashFunction(key);
        int index = hashRes % table.length;

        if (table[index] != null && table[index].key == key) {
            return table[index].value;
        } else {
            int tempIndex = (index + 1) % table.length;

            while (tempIndex != index) {
                if (table[tempIndex].key == key) {
                    return table[tempIndex].value;
                }

                tempIndex = (tempIndex + 1) % table.length;
            }
            System.out.println("not found the key");

            return null;
        }
    }

    private int hashFunction(K key) {
        return 0;
    }

    void print() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.println("[" + table[i].key + " : " + table[i].value + "]");
            }else
                System.out.println("null");
        }
    }
}
