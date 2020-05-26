package BST;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    void insert(T newData) {
        Node newNode = new Node(newData);

        if (isEmpty()) {
            this.root = newNode;
        } else {
            Node<T> temp = root;

            while (temp != null) {
                if (newData.compareTo(temp.data) > 0) {
                    if (temp.rightChild == null) {
                        temp.rightChild = newNode;
                        return;
                    }

                    temp = temp.rightChild;

                } else if (newData.compareTo(temp.data) < 0) {
                    if (temp.leftChild == null) {
                        temp.leftChild = newNode;
                        return;
                    }

                    temp = temp.leftChild;

                } else {
                    return;
                }
            }
        }
    }


    void insertRecursive(T newData) {
        root = insertRecursive(root, newData);
    }

    private Node<T> insertRecursive(Node<T> node, T newData) {
        if (node == null)
            return new Node<>(newData);
        else {
            if (newData.compareTo(node.data) > 0) {
                node.rightChild = insertRecursive(node.rightChild, newData);
            } else if (newData.compareTo(node.data) < 0) {
                node.rightChild = insertRecursive(node.leftChild, newData);
            }

            return node;
        }
    }

    void preorder() {
        System.out.println("pre order: ");
        preorder(root);
        System.out.println();
    }

    private void preorder(Node<T> node) {
        if (node != null) {
            System.out.print(" " + node.data);
            preorder(node.leftChild);
            preorder(node.rightChild);
        }
    }

    void inorder() {
        System.out.print("inorder : ");
        inorder(root);
        System.out.println("");
    }

    private void inorder(Node<T> node) {
        if (node != null) {
            inorder(node.leftChild);
            System.out.print(" " + node.data);
            inorder(node.rightChild);
        }
    }

    void postorder() {
        System.out.print("postorder : ");
        postorder(root);
        System.out.println("");
    }

    private void postorder(Node<T> node) {
        if (node != null) {
            postorder(node.leftChild);
            postorder(node.rightChild);
            System.out.print(" " + node.data);

        }
    }

    boolean search(T data) {
        if (isEmpty()) {
            System.out.println("Bst is empty!");
            return false;
        } else {
            Node temp = root;
            while (temp != null) {
                if (data.compareTo((T) temp.data) > 0) {
                    temp = temp.rightChild;
                } else if (data.compareTo((T) temp.data) < 0) {
                    temp = temp.leftChild;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isEmpty() {
        return this.root == null;
    }

    int sum() {
        return sumRecursive(root);
    }

    private int sumRecursive(Node node) {
        if (node == null)
            return 0;
        else {
            if (node.data instanceof Number) {
                return (Integer) node.data + sumRecursive(node.rightChild) + sumRecursive(node.leftChild);
            }
            return 0;
        }
    }

    int size() {
        return sizeRecursive(root);
    }

    private int sizeRecursive(Node node) {
        if (node == null)
            return 0;
        else {
            return 1 + sizeRecursive(node.leftChild) + sizeRecursive(node.rightChild);
        }
    }

    int fullNodeCount(){
        return fullNodeCount(root);
    }

    private int fullNodeCount(Node node){
        if (node == null)
            return  0;
        else {
            if (node.rightChild != null && node.leftChild != null)
                return 1 + fullNodeCount(node.rightChild) + fullNodeCount(node.leftChild);
            else
                return 0 + fullNodeCount(node.rightChild) + fullNodeCount(node.leftChild);
        }
    }

    private T findMaxRecursive(Node node){
        if (node.rightChild == null)
            return (T)node.data;
        else
            return findMaxRecursive(node.rightChild);
    }


    // the last example
    int height(){
        return height(root);
    }

    private int height(Node<T> node){
        if (node == null) {
            return -1;
        }
        else {
            return +1 + Math.max(height(node.leftChild), height(node.rightChild));
        }
    }
}
