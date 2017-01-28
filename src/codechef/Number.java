package codechef;

/**
 * Created by neelabhsingh on 08/01/17.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Number
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int i=2,j=2;
        if(n==1)
            System.out.println("3");
        else if(n==2)
            System.out.println("4");
        else
        {
            while(i<n)
            {
                i=i+(int)Math.pow(2,j);
                j++;
                //System.out.println("--->"+i);
            }
            i=i-(int)Math.pow(2,j-1);
            //System.out.println("1--->"+i);
            i=n-i-1;
            //System.out.println("2--->"+i);
            String str="";
            int x=n;
            int count=0;
            while(i!=0)
            {
                if(i%2==0)
                {
                    str=str+"3";
                    count++;
                }
                else
                {
                    str=str+"4";
                    count++;
                }
                i=i/2;
            }
            int m=0;
            while(m++<j-1-count)
                str=str+"3";
            String str2=new StringBuffer(str).reverse().toString();
            System.out.println(str2);
        }
    }

}