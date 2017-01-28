package tree;

/**
 * Created by neelabhsingh on 27/12/16.
 */
public class MaxDepth {
    public static void main(String[] args) {
        BinaryTree br = new BinaryTree();
        br.constructTree(br);
        System.out.println("Max Depth of Binary Tree is = " +maxDepth(br.root));
    }
    public static int maxDepth(Node root){
        if(root==null){
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft, maxRight)+1;
    }
}
