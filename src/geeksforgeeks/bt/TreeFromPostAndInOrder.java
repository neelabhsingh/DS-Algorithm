package geeksforgeeks.bt;

import util.binary_tree.BinaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Created by neelabhsingh on 13/01/17.
 */
public class TreeFromPostAndInOrder {
    private static int postIndex=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []inString = br.readLine().split(" ");
        String []postString = br.readLine().split(" ");
        int size1 = inString.length;
        int [] inOrder = new int[size1];
        for(int i=0; i<size1;i++){
            inOrder[i] = Integer.parseInt(inString[i]);
        }
        int size2 = postString.length;
        int [] postOrder = new int[size2];
        for(int i=0; i<size2; i++){
            postOrder[i] = Integer.parseInt(postString[i]);
        }
        Index index = new Index();
        index.index = size2-1;
        postIndex = size2-1;
        BinaryTree bt = constructTree(inOrder, 0, inOrder.length-1, postOrder, index);
        bt.preOrder(bt);
        System.out.println();
        BinaryTree bt2 = constructTree_by_static(inOrder, 0, inOrder.length-1, postOrder);
        bt.preOrder(bt2);
    }

    public static BinaryTree constructTree(int[] in, int start, int end, int [] post, Index postIndex) throws Exception{
        if(start>end){
            return null;
        }
        BinaryTree bt = new BinaryTree(post[postIndex.index]);
        (postIndex.index)--;
        int newIndex = search(in, start, end, bt.getData());
        if(newIndex==-1){
            throw new Exception();
        }
        bt.right = constructTree(in, newIndex+1, end, post, postIndex);
        bt.left = constructTree(in, start, newIndex-1, post, postIndex);
        return bt;
    }
    public static BinaryTree constructTree_by_static(int[] in, int start, int end, int [] post) throws Exception{
        if(start>end){
            return null;
        }
        BinaryTree bt = new BinaryTree(post[postIndex]);
        postIndex--;
        int newIndex = search(in, start, end, bt.getData());
        if(newIndex==-1){
            throw new Exception();
        }
        bt.right = constructTree_by_static(in, newIndex+1, end, post);
        bt.left = constructTree_by_static(in, start, newIndex-1, post);
        return bt;
    }
    public static int search(int [] in, int start, int end, int value){
        for(int i=start; i<=end; i++){
            if(in[i]==value){
                return i;
            }
        }
        return -1;
    }
}
class Index{
    int index;
}

