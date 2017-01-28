package LRU.demo1;

/**
 * Created by neelabhsingh on 21/01/17.
 */
public class Node {
    private int pageNumber;
    private Node prev;
    private Node next;
    public Node(int pageNumber){
        this.pageNumber = pageNumber;
    }
    public int getPageNumber(){
        return pageNumber;
    }
    Node getNext(){
        return next;
    }
    Node getPrev(){
        return prev;
    }
    public void setNext(Node next){
        this.next=next;
    }
    public void setPrev(Node prev){
        this.prev = prev;
    }
    public String toString() {
        return pageNumber + "  ";
    }
}
