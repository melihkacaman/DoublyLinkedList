package HashTable_Array;

public class HashEntry<K,V> {
    K key;
    V value;

    public HashEntry(K key,V value) {
        this.value = value;
        this.key = key;
    }
}
