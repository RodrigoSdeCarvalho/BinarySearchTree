public class TreeTraversal {
    String tree;

    public void InOrder(Node root) {
        if (root == null) {
            return;
        }
        InOrder(root.getLeftChild());
        this.tree += root.getKey() + " ";
        InOrder(root.getRightChild());
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        this.tree += root.getKey() + " ";
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        this.tree += root.getKey() + " ";
    }

    public void printOutputFormatString() {
        char[] numOfTreeNodesArr = this.tree.toCharArray();
        System.out.println(numOfTreeNodesArr);
    }
}
