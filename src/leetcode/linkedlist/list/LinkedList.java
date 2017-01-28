package leetcode.linkedlist.list;

/**
 * Created by neelabhsingh on 08/01/17.
 */
public class LinkedList {
    private Node head;
    public void add(int data){
        Node tempNode = new Node(data);
        if(head==null){
            head = tempNode;
        }else{
            Node current =head;
            while (current.next!=null){
                current = current.next;
            }
            current.next = tempNode;
        }
    }
    public Node getHead(){
        return this.head;
    }
    public void setHead(Node head){
        this.head = head;
    }
    public void printLinkedList(){
        Node curr = head;
        while (curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
}
