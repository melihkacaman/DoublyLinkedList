package BST;

public class Node<T extends Comparable<T>> {
    T data;
    Node<T> leftChild, rightChild;

    public Node(T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
