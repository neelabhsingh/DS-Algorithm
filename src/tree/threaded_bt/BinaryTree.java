package tree.threaded_bt;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by neelabhsingh on 11/01/17.
 */
public class BinaryTree {
    Node root;
    public void populateQueue(Node node, Queue<Node> q){
        if(node==null){
            return;
        }
        if(node.left!=null){
            populateQueue(node.left, q);
        }
        q.add(node.left);
        if(node.right!=null){
            populateQueue(node.right, q);
        }
    }
    public void createThreadedUtil(Node node, Queue<Node> q){
        if(node==null){
            return;
        }
        if(node.left!=null){
            createThreadedUtil(node.left, q);
        }
        q.remove();
        if(node.right!=null){
            createThreadedUtil(node.right, q);
        }else{
            node.right= q.poll();
            node.isThreaded = true;
        }
    }
    public void createThreaded(Node node)
    {
        // Create a queue to store inorder traversal
        Queue<Node> q = new LinkedList<Node>();

        // Store inorder traversal in queue
        populateQueue(node, q);

        // Link NULL right pointers to inorder successor
        createThreadedUtil(node, q);
    }
    Node leftMost(Node node)
    {
        while (node != null && node.left != null)
            node = node.left;
        return node;
    }

    // Function to do inorder traversal of a threadded binary tree
    void inOrder(Node node)
    {
        if (node == null)
            return;

        // Find the leftmost node in Binary Tree
        Node cur = leftMost(node);

        while (cur != null)
        {
            System.out.print(" " + cur.data + " ");
            // If this Node is .a thread Node, then go to
            // inorder successor
            if (cur.isThreaded == true)
                cur = cur.right;
            else // Else go to the leftmost child in right subtree
                cur = leftMost(cur.right);
        }
    }
}
