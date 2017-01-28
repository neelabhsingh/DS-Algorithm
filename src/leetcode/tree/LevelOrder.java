package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
/**
 * Created by neelabhsingh on 25/01/17.
 */

public class LevelOrder {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node root =bt.constructTree(bt);
    }
    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<>();
        LinkedList<Node> current = new LinkedList<>();
        LinkedList<Node> next = new LinkedList<>();
        current.add(root);
        while (!current.isEmpty()){
            Node node = current.remove();
            if(node.left!=null){
                next.add(node.left);
            }
            if(node.right!=null){
                next.add(node.right);
            }
            level.add(node.data);
            if(current.isEmpty()){
                LinkedList temp = current;
                current = next;
                next = temp;
                result.add(level);
                level.clear();
            }
        }
        return result;
    }
}
