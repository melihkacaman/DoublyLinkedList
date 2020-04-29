package BST;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree<Integer> liste = new BinarySearchTree();

        liste.preorder();
        liste.insertRecursive(15);
        liste.insertRecursive(19);
        liste.insertRecursive(29);
        liste.preorder();

    }
}
