public class BinarySearchTree {
    Node root;
    int height;

    public Node search(Node root, int searchedNodeKey) {
        if (searchedNodeKey == root.getKey()) return root;
        if (searchedNodeKey <= root.getKey()) {
            if (root.hasLeftChild()) return search(root.getLeftChild(), searchedNodeKey);
        } else if (root.hasRightChild()) return search(root.getRightChild(), searchedNodeKey);
        
        return root;
    }

    public boolean nodeIsInTree(Node node) {
        return node == search(node, node.getKey());
    }

    public void insert(int insertedNodeKey) {
        Node insertedNode = new Node(insertedNodeKey);
        if (this.root == null) {
            this.root = insertedNode;
            return;
        }

        Node insertedNodeParent = search(this.root, insertedNodeKey);

        if (insertedNodeParent.getKey() == insertedNode.getKey()) { //If it's the same, node already is in tree.
            System.out.println("Key already in tree.");
            return;
        }
        if (insertedNodeParent.getKey() < insertedNode.getKey()) {
            insertedNodeParent.setRightChild(insertedNode);
            insertedNode.setParent(insertedNodeParent);
        } else {
            insertedNodeParent.setLeftChild(insertedNode);
            insertedNode.setParent(insertedNodeParent);
        }
    }

    public void remove(int removedNodeKey) {
        Node removedNode = search(this.root, removedNodeKey);
        Node removedNodeParent = removedNode.getParent();

        if (!removedNode.hasAChild()) { //Simply removes the reference to the node.
            if (removedNodeParent.getKey() < removedNode.getKey()) {
                removedNodeParent.setRightChild(null);
            } else {
                removedNodeParent.setLeftChild(null);
            }
        }

        if (removedNode.hasOnlyOneChild()) { //Promotes the child to parent.
            if (removedNodeParent.getKey() < removedNode.getKey()) {
                removedNodeParent.setRightChild(removedNode.getOnlyChild());
            } else {
                removedNodeParent.setLeftChild(removedNode.getOnlyChild());
            }
        }

        Node successorNode = removedNode.getRightChild();
        if (removedNode.hasBothChildren()) { //(o nó mais à esquerda da subárvore direita)
            while (successorNode.getLeftChild() != null) {
                successorNode = successorNode.getLeftChild();
            }
            if (removedNodeParent.getKey() < removedNode.getKey()) {
                removedNodeParent.setRightChild(successorNode);
            } else {
                removedNodeParent.setLeftChild(successorNode);
            }
            successorNode.getParent().setLeftChild(successorNode.getRightChild());
            successorNode.getRightChild().setParent(successorNode.getParent());
            successorNode.setParent(removedNodeParent);
        }
    }

    public void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.getLeftChild());
        System.out.println(root.getKey());
        printInOrder(root.getRightChild());
    }

    public void printPreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getKey());
        printPreOrder(root.getLeftChild());
        printPreOrder(root.getRightChild());
    }

    public void printPostOrder(Node root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.getLeftChild());
        printPostOrder(root.getRightChild());
        System.out.println(root.getKey());
    }
}
