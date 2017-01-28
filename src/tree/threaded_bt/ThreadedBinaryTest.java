package tree.threaded_bt;

/**
 * Created by neelabhsingh on 11/01/17.
 */
public class ThreadedBinaryTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.createThreaded(tree.root);
        System.out.println("Inorder traversal of created threaded tree");
        tree.inOrder(tree.root);
    }
}
