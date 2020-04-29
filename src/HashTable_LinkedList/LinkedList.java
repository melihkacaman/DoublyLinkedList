package HashTable_LinkedList;

class LinkedList<K,V> {
    protected Node<K,V> head;

    void addFirst(K key, V value){
        Node<K,V> newNode = new Node<>(key,value);
        newNode.nextNode = head;
        head = newNode;
    }

    public void print() {
        Node temp = head;

        while (temp!= null){
            System.out.print("Key: "+ temp.key + "Value: " + temp.value + "-->");
            temp = temp.nextNode;
        }
        System.out.println("null");
    }
}
