package hackerrank.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 24/01/17.
 */
public class Multiply {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0){
            int N = Integer.parseInt(br.readLine());
            System.out.println(getSpecialNumber(N));
        }
    }
    public static int getSpecialNumber(int N){
        int x=0;
        int y=0;
        if(N==1 || N ==2 || N==4) {
            return 2;
        }
        int [] num= new int[N];
        num[0] = 0;
        for(int i= 1 ; i < N ; i++)
            num[i] = -1;
        num[4%N] = 1;
        int value = 4%N;
        for(int i=2 ; i<=N+2 ; i++)
        {
            if(num[(value*10 + 4) % N] != -1)
            {
                x = i;
                y = num[(value*10 + 4) % N] ;
                break;
            }
            else
            {
                num[(value*10 + 4) % N]  = i;
                value = (value*10 + 4)%N;
            }
        }
        return 2*x-y;
    }
}
