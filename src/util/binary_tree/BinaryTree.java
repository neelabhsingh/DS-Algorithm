package util.binary_tree;

/**
 * Created by neelabhsingh on 12/01/17.
 */
public class BinaryTree{
    public int data;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public int getData(){
        return data;
    }
    public void preOrder(BinaryTree bt){
        if(bt!=null){
            System.out.print(bt.data+" ");
            preOrder(bt.left);
            preOrder(bt.right);
        }
    }
}
