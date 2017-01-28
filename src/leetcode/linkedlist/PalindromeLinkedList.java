package leetcode.linkedlist;

import leetcode.linkedlist.list.LinkedList;
import leetcode.linkedlist.list.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 11/01/17.
 */
public class PalindromeLinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] strings = br.readLine().split(" ");
        LinkedList ll = new LinkedList();
        int size = strings.length;
        for(int i=0; i<size; i++){
            ll.add(Integer.parseInt(strings[i]));
        }
        ll.printLinkedList();
        System.out.println("Check for Palindrome");
        System.out.println(isPalindromeLinkedList(ll.getHead()));
    }
    public static Node reverse(Node root){
        Node curr = root;
        Node prev = null;
        while (curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static boolean isPalindromeLinkedList(Node head){
        boolean result = true;
        Node slowMove = head;
        Node fastMove = head;
        Node prevSlowMove = head;
        Node middleElement =null;
        if(head!=null && head.next!=null) {
            while (fastMove != null && fastMove.next != null) {
                fastMove = fastMove.next.next;
                prevSlowMove = slowMove;
                slowMove = slowMove.next;
            }
            if(fastMove!=null){
                middleElement = slowMove;
                slowMove = slowMove.next;
            }
            prevSlowMove.next =null;

            Node reverseHead = reverse(slowMove);
            result = compareLists(head, reverseHead);
            if(middleElement!=null){
                middleElement.next = reverse(reverseHead);
            }else {
                prevSlowMove.next = reverse(reverseHead);
            }
        }
        return result;
    }
    public static boolean compareLists(Node root1, Node root2){
        while (root1!=null && root2!=null){
            if(root1.data!=root2.data){
                return false;
            }
            root1 = root1.next;
            root2 = root2.next;
        }
        if(root1==null && root1==null){
            return true;
        }else {
            return false;
        }
    }
}
