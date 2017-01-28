package linkedlist;

import linkedlist.list.Node;

/**
 * Created by neelabhsingh on 01/12/16.
 */

public class AddTwoNumbers {
    static int carry =0;
    public static void main(String [] args){

    }
    public Node addTwoNumbers(Node head1, Node head2){
        int size1 = getLinkedListSize(head1);
        int size2 = getLinkedListSize(head2);
        if(size1==size2){
            return addSameSize(head1, head2);
        }
        Node largerListHead = null;
        Node smallestListHead = null;
        if(size1> size2){
            largerListHead = head1;
            smallestListHead = head2;
        }else {
            largerListHead = head2;
            smallestListHead = head2;
        }
        int diff = Math.abs(size1-size2);
        Node curr = largerListHead;
        while (diff>0){
            curr=curr.next;
        }
        Node result = addSameSize(curr, smallestListHead);
        Node finalResult = addCarryToRemaining(largerListHead, curr, result);
        return finalResult;
    }
    public static Node addSameSize(Node head1, Node head2){
        if(head1 == null){
            return null;
        }
        Node result = new Node();
        result.next = addSameSize(head1.next, head2.next);
        int sum = head1.data + head2.data + carry;
        carry = sum/10;
        sum = sum%10;
        result.data = sum;
        return result;
    }
    public static Node addCarryToRemaining(Node head, Node curr, Node result){
        if(curr == result){
            return result;
        }
        Node temp = new Node();
        temp.next = addCarryToRemaining(head.next, curr, result);
        int sum = head.data + carry;
        carry = sum/10;
        sum = sum%10;
        temp.data = sum;
        return temp;
    }
    public static int getLinkedListSize(Node head){
        int count =0;
        Node temp = head;
        while (temp!=null){
            count ++;
            temp= temp.next;
        }
        return count;
    }
}
