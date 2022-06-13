public class Node { //Static because a Node can be created without instantiating a BST.
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
    public void setParent(Node newParent) {
        this.parent = newParent;
    }

    public Node getLeftChild() {
        return leftChild;
    }
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

/*    public int calcNewHeight(int height) { //Calculates the new height for AVL. Implemented later.
        return 0;
    }*/

    public Node(int key) {
        this.key = key;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    public boolean hasAChild() {
        return hasLeftChild() || hasRightChild();
    }

    public boolean hasOnlyOneChild() {
        return ((hasLeftChild() && !hasRightChild()) || (!hasLeftChild() && hasRightChild()));
    }

    public boolean hasBothChildren() {
        return (hasLeftChild() && hasRightChild());
    }

    public Node getOnlyChild() {
        if (hasLeftChild() && !hasRightChild()) return this.getLeftChild();
        if (!hasLeftChild() && hasRightChild()) return this.getRightChild();
        return null;
    }
}
