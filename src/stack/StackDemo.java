package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 18/01/17.
 */
public class StackDemo {
    public static void main(String[] args) throws IOException{
        BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
        int ch,temp;
        StackLL sl=new StackLL();
        do
        {
            System.out.println("##MENU##");
            System.out.println("1.Insert an element in stack");
            System.out.println("2.Remove an element");
            System.out.println("3.Peek element");
            System.out.println("4.Display Stack");
            System.out.println("5.Exit");
            System.out.println("Enter Choice");
            ch=Integer.parseInt(obj.readLine());
            switch (ch)
            {
//                case 1:System.out.println("Enter element to be inseted");
//                    temp=Integer.parseInt(obj.readLine());
//                    sl.push(temp);
//                    break;
//                case 2:temp=sl.pop();
//                    System.out.println("Popped element is "+temp);
//                    break;
//                case 3:temp=sl.peek();
//                    System.out.println("Peeked element is "+temp);
//                    break;
//                case 4:sl.display();
            }
        }
        while(ch!=5);
    }
}
