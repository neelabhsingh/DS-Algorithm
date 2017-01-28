package stack;

/**
 * Created by neelabhsingh on 18/01/17.
 */
public class StackLL {
    Node top = null;
    public boolean isEmpty(){
        if(top == null){
            return false;
        }else {
            return true;
        }
    }
    public void push(int data){
        Node temp = new Node(data);
        temp.next = top;
        top = temp;
    }
    public Node pop(){
        if(isEmpty()==true){
            System.out.println("Stack is empty");
            return null;
        }
        Node temp = top;
        top = top.next;
        return temp;
    }
    public Node peek(){
        if(isEmpty()==true){
            System.out.println("Stack is empty");
            return null;
        }
        return top;
    }
    public void display(){
        if(isEmpty()==true){
            System.out.println("Nothing to display");
        }else{
            Node current = top;
            while (current!=null){
                System.out.print(current.data+" ");
            }
        }
    }
}
