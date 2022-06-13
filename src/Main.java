import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeTraversal traversal = new TreeTraversal();

        Scanner scanner = new Scanner(System.in);
        
        int numOfTreeNodes = scanner.nextInt();

        for (int i = 0; i <= numOfTreeNodes - 1; i++) {
            int nodeKey = scanner.nextInt();
            bst.insert(nodeKey);
        }

        scanner.close();

        traversal.tree = "";
        traversal.preOrder(bst.root);
        traversal.printOutputFormatString();

        traversal.tree = "";
        traversal.InOrder(bst.root);
        traversal.printOutputFormatString();

        traversal.tree = "";
        traversal.postOrder(bst.root);
        traversal.printOutputFormatString();
    }
}
