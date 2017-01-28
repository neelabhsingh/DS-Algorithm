package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by neelabhsingh on 27/12/16.
 */
public class WidthOfTree {
    public static void main(String[] args) {
        BinaryTree br = new BinaryTree();
        br.constructTree(br);
        System.out.println("max width of Binary Tree is = " +getMaxWidth(br.root));
    }
    /* Function to get the maximum width of a binary tree*/
    public static int getMaxWidth(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int maxCount = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            int count = queue.size();
            maxCount = Math.max(maxCount, count);
            while (count-->0){
                Node temp = queue.poll();
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
        return maxCount;
    }

}
