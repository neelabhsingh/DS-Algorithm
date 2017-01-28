package linkedlist.list;

/**
 * Created by neelabhsingh on 08/01/17.
 */
public class LinkedList {
    private Node root;
    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public LinkedList(Node root){
        this.root = root;
    }
    public void insert(int data){
        Node curr = root;
        if(curr==null){
            curr = new Node(data);
            root=curr;
            return;
        }
        while (curr.next!=null){
            curr = curr.next;
        }

        curr.next = new Node(data);
    }
    public void printList(){
        Node curr = this.root;
        while (curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
}
