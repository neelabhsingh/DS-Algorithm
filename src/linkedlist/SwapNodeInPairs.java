package linkedlist;

import linkedlist.list.LinkedList;
import linkedlist.list.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 08/01/17.
 */
public class SwapNodeInPairs {
    public static void main(String[] args) throws IOException{
        Node head = null;
        LinkedList ll = new LinkedList(head);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String [] data = br.readLine().split(" ");
        for(int i=0; i<size; i++){
            int value = Integer.parseInt(data[i]);
            ll.insert(value);
        }
        //ll.printList();
        Node newHead = swapInPairs(ll.getRoot());
        ll.setRoot(newHead);
        System.out.println();
        ll.printList();
    }
    public static Node swapInPairs(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newHead = null;
        Node p1 = head;
        Node p2 = head.next;
        Node pre = head;
        while(p1!=null && p2!=null){
            if(newHead==null){
                newHead = p2;
            }
            pre.next =p2;
            Node nextNode = p2.next;
            p2.next = p1;
            pre =p1;
            p1.next = nextNode;
            p1=nextNode;
            if(nextNode!=null){
                p2=nextNode.next;
            }
        }
        return newHead;
    }
}
