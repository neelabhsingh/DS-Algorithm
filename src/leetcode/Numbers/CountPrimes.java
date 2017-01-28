package leetcode.Numbers;

import java.util.Scanner;

/**
 * Created by neelabhsingh on 06/01/17.
 */
public class CountPrimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        System.out.println(countPrimesEfficient(n));
    }
    public static int countPrimesEfficient(int n) {
        if(n <=1){
            return 0;
        }
        boolean [] isPrime = new boolean[n];
        for(int i=2; i<n; i++){
            isPrime[i] = true;
        }
        for(int i=2; i<=Math.sqrt(n-1); i++){
            if(isPrime[i]){
                for(int j = i+i; j<n; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        int count =0;
        for(int i=0; i<n; i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
    }
    public static int countPrimesLessEfficient(int n) {
        int count = 0;
        for(int j=2; j<n;j++){
            if(isPrime(j)){
                count++;
            }
        }
        return count;
    }
    public static boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
