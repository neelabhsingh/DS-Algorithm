package HackerEarth.capillary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by neelabhsingh on 08/01/17.
 */
public class CoolNumber {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int testCases = Integer.parseInt(br.readLine());
//        while (testCases-- > 0){
//            String [] str = br.readLine().split(" ");
//            int l = Integer.parseInt(str[0]);
//            int r = Integer.parseInt(str[1]);
//            System.out.println(coolNumber(l, r));
//        }
        for(int i=1; i<1024; i++){
            System.out.println(getNumber(i));
        }
    }
    public static BigInteger coolNumber(int l, int r){
        BigInteger sum = BigInteger.ZERO;;
        int position = 1;
        for(int i=l; i<=r; i++){
            int value = getNumber(position);
            if(i<=value){
                sum.add(new BigInteger(Integer.toString(value)));
            }else{
                while (value<i){
                    position++;
                    value = getNumber(position);
                }
                sum.add(new BigInteger(Integer.toString(value)));
            }
        }
        return sum;
    }
    public static int getNumber(int n){
        int result = Integer.MAX_VALUE;
        int i=2,j=2;
        if(n==1) {
            result = 2;
        } else if(n==2){
            result = 5;
        } else {
            while(i<n)
            {
                i=i+(int)Math.pow(2,j);
                j++;
            }
            i=i-(int)Math.pow(2,j-1);
            i=n-i-1;
            String str="";
            int x=n;
            int count=0;
            while(i!=0)
            {
                if(i%2==0)
                {
                    str=str+"2";
                    count++;
                }
                else
                {
                    str=str+"5";
                    count++;
                }
                i=i/2;
            }
            int m=0;
            while(m++<j-1-count)
                str=str+"2";
            String str2=new StringBuffer(str).reverse().toString();
            result = Integer.parseInt(str2);
        }
        return result;
    }
}
