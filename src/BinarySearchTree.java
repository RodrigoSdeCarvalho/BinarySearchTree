/**
 * BinarySearchTree
 */
public class BinarySearchTree {
    class Node {
        private final int key;
        private int height;
        private Node parent;
        private Node leftChild;
        private Node rightChild;

        public int getKey() {
            return key;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Node getParent() {
            return parent;
        }
        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }
        
        public int setNewRight(int height) { //Calculates the new height for AVL.
            return 0;
        }

        public Node(int key) {
            this.key = key;
        }

        public boolean hasLeftChild() {
            if (this.leftChild == null) return false;
            return true;
        }

        public boolean hasRightChild() {
            if (this.rightChild == null) return false;
            return true;
        }
    }

    Node root;
    int height;

    public BinarySearchTree(int rootKey) {
        this.root = new Node(rootKey);
    }

    public Node search(Node root, int searchedNodeKey) {
        if (searchedNodeKey == root.key) return root;

        if (searchedNodeKey <= root.key) {
            if (root.hasLeftChild()) return search(root.leftChild, searchedNodeKey);
            if (root.hasRightChild()) return search(root.rightChild, searchedNodeKey);

        }

        return root;
    }

    public boolean nodeIsInTree(Node node) {
        return node == search(node, node.key);
    }

    public void insert(int insertedNodeKey) {
        Node insertedNode = new Node(insertedNodeKey);
    }

    public void remove(int removedNodeKey) {
        Node removedNode = search(this.root ,removedNodeKey);

    }

    public void printInOrder() {

    }

    public void printPreOrder() {

    }

    public void printPostOrder() {

    }
}
