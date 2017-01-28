package hackerrank.matrix;

/**
 * Created by neelabhsingh on 24/01/17.
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TicketResellers {
    public static void main(String[] args) throws IOException{
        int[] scalperTicket=null;
        Scanner scanner=new Scanner(System.in);

        int scalperNo=scanner.nextInt();
        scalperTicket=new int[scalperNo];

        for(int i=0;i<scalperNo;i++){
            scalperTicket[i]=scanner.nextInt();

        }

        int sell=scanner.nextInt();
        //long result=maximumAmount(scalperTicket, sell);
        long result=getMaxAmount(scalperTicket, sell);
        System.out.println(result);
        scanner.close();

    }

    public static long maximumAmount(int[] a, long k) {
        int size = a.length;
        int[] count=new int[100];
        for(int i=0;i<size;i++){

            count[a[i]]++;
        }
        long result=findMax(a,k,count);
        return result;
    }
    public static long findMax(int[] ticket,long k,int[] count) {
        int max=0;
        long result=0;
        while(k>0){
            Arrays.sort(ticket);
            max=ticket[ticket.length-1];

            if(count[max]>k){
                result=result+k*max;
                //count[max]=count[max]-k;
                //count[max-1]=count[max-1]+k;
                k=0;
            }

            else{
                result=result+max*count[max];
                count[max-1]=count[max-1]+count[max];

                for(int i=count[max];i>=0;i--){
                    ticket[ticket.length-1-i]--;
                }

                k=k-count[max];
            }

        }
        return result;
    }
    public static long getMaxAmount(int[] a, int k) {
        int n = a.length;
        Arrays.sort(a);
        long totalCost = 0;
        int scalperCount = 1;
        for (int i = n - 1; i >= 0; i--) {

            int diff = 0;

            if (i > 0) {

                diff = a[i] - a[i - 1];

            } else {

                diff = a[i];

            }

            if (scalperCount * diff >= k) {

                int x = k / scalperCount;

                totalCost += scalperCount * ((a[i] * (a[i] + 1)) - ((a[i] - x) * ((a[i] - x) + 1))) / 2;

                k = k - x * scalperCount;

                long y = k % scalperCount;

                totalCost += (a[i] - x) * y;

                k = 0;

                break;

            } else {

                totalCost += scalperCount * (((a[i] * (a[i] + 1)) - ((a[i] - diff) * ((a[i] - diff) + 1)))

                        / 2);

                k -= scalperCount * diff;

            }

            scalperCount++;

        }
        if (k > 0) {
            return -1;

        }
        return totalCost;
    }
}
