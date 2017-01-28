package tree.threaded_bt;

/**
 * Created by neelabhsingh on 11/01/17.
 */
public class Node {
    int data;
    Node left;
    Node right;
    boolean isThreaded;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
