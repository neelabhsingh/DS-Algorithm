package geeksforgeeks.bt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by neelabhsingh on 12/01/17.
 */
public class BoundaryTraversal {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(2);
        binaryTree.right = new BinaryTree(3);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.right = new BinaryTree(5);
        binaryTree.right.left = new BinaryTree(6);
        binaryTree.right.right = new BinaryTree(7);
        List<Integer> traversal = binaryTree.printBoundary(binaryTree);
        Iterator itr = traversal.iterator();
        while (itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
    }
}

class BinaryTree{
    int data;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    //Only left Pre order traversal, leaving the left
    private void preOrder(BinaryTree root, List<Integer> list){
        if(!isLeaf(root)){
            list.add(root.data);
        }
        if(root.left!=null){
            preOrder(root.left, list);
        }
    }
    private void inOrderOnlyLeaf(BinaryTree bt, List<Integer> list){
        if(bt!=null){
            inOrderOnlyLeaf(bt.left, list);
            if(isLeaf(bt)){
                list.add(bt.data);
            }
            inOrderOnlyLeaf(bt.right, list);
        }
    }
    private void postOrder(BinaryTree bt, List<Integer> list){
        if(bt!=null && bt.right!=null) {
            postOrder(bt.right, list);
        }
        if(!isLeaf(bt)){
            list.add(bt.data);
        }
    }
    private boolean isLeaf(BinaryTree bt){
        if(bt!=null && bt.left==null && bt.right==null){
            return true;
        }else {
            return false;
        }
    }
    public List<Integer> printBoundary(BinaryTree root){
        List<Integer> arrayList = new ArrayList<>();
        preOrder(root, arrayList);
        inOrderOnlyLeaf(root, arrayList);
        postOrder(root.right, arrayList);
        return arrayList;
    }
}
