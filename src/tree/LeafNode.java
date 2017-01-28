package tree;

/**
 * Created by neelabhsingh on 27/12/16.
 */
public class LeafNode {
    public static void main(String[] args) {
        BinaryTree br = new BinaryTree();
        br.constructTree(br);
        System.out.println("Total Leaf Node of Binary Tree is = " +countLeafNodes(br.root));
    }
    public static int countLeafNodes(Node root){
        if(root ==null){
            return 0;
        }
        if(root.left == null && root.right ==null){
            return 1;
        }
        return countLeafNodes(root.left)+ countLeafNodes(root.right);
    }
}
