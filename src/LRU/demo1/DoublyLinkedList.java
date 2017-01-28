package LRU.demo1;

/**
 * Created by neelabhsingh on 21/01/17.
 */
public class DoublyLinkedList {
    private final int size;
    private int currSize;
    private Node head;
    private Node tail;
    public DoublyLinkedList(int size) {
        this.size = size;
        currSize = 0;
    }

    public int getCurrSize() {
        return currSize;
    }

    public int getSize() {
        return size;
    }

    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }
    public void printList(){
        if(head == null) {
            return;
        }
        Node tmp = head;
        while(tmp != null) {
            System.out.print(tmp);
            tmp = tmp.getNext();
        }
    }

    public Node addPageToList(int pageNumber){
        Node pageNode = new Node(pageNumber);
        if(head==null){
            currSize=1;
            head= pageNode;
            tail= pageNode;
            return pageNode;
        }else if(currSize < size){
            currSize++;
        }else{
            tail = tail.getPrev();
            tail.setNext(null);
        }
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;
        return pageNode;
    }

    public void movePageToHead(Node pageNode){
        if(pageNode==null || pageNode==head){
            return;
        }
        if(pageNode ==tail){
            tail = tail.getPrev();
            tail.setNext(null);
        }

        Node prevNode = pageNode.getPrev();
        Node nextNode = pageNode.getNext();
        prevNode.setNext(nextNode);
        if(nextNode!=null) {
            nextNode.setPrev(prevNode);
        }
        pageNode.setPrev(null);
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;
    }
}
