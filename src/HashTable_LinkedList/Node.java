package HashTable_LinkedList;

public class Node<K,V> {
    K key;
    V value;
    Node<K,V> nextNode;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.nextNode = null; 
    }
}
