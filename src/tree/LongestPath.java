package tree;

/**
 * Created by neelabhsingh on 25/01/17.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *Longest Path from root to leaf Node
 * */
public class LongestPath {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node root =bt.constructTree(bt);
        List path = printPath(root);
        Iterator itr = path.iterator();
        while (itr.hasNext()){
            System.out.print(itr.next() +" ");
        }
    }
    public static List<Integer> printPath(Node root){
        if(root ==null){
            return null;
        }
        List<Integer> path = new ArrayList<>();
        path.add(root.data);
        List result = getMaxList(printPath(root.left), printPath(root.right));
        if(result!=null) {
            path.addAll(result);
        }
        return path;
    }
    public static List<Integer> getMaxList(List<Integer> list1, List<Integer> list2){
        if(list1==null && list2==null){
            return null;
        }
        if(list1==null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.size()> list2.size()){
            return list1;
        }else {
            return list2;
        }
    }
}
