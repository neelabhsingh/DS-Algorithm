package Array;

/**
 * Created by neelabhsingh on 25/01/17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Q. Given an array of numbers. Print all the pairs (2) of numbers in the array if the sum of
 * those numbers is also present in the array. Write in C
 */
public class PairsWithSumInArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        int size = str.length;
        int [] numbers = new int[size];
        for(int i=0; i<size; i++){
            numbers[i] = Integer.parseInt(str[i]);
        }
        List<Triplet> triplets = getAllTriplets(numbers);
        Iterator itr = triplets.iterator();
        while (itr.hasNext()){
            Triplet triplet = (Triplet) itr.next();
            System.out.println(triplet+", value("+numbers[triplet.getA()]+", "+numbers[triplet.getB()]+", "+numbers[triplet.getC()]+")");
        }
    }
    public static List<Triplet>  getAllTriplets(int [] array){
        List<Triplet> triplets = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int size = array.length;
        for(int i=0; i<size; i++){
            hashMap.put(array[i], i);
        }
        for(int i=0; i<size-2; i++){
            for(int j=i+1; j<size; j++){
                int a = array[i];
                int b = array[j];
                if(hashMap.containsKey(a+b)){
                    triplets.add(new Triplet(i, j, hashMap.get(a+b)));
                }
            }
        }
        return triplets;
    }
}
class Triplet{
    private int a;
    private int b;
    private int c;

    public Triplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Index"+"("+a+","+b+","+c+")";
    }
}