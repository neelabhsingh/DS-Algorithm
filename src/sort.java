import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 25/01/17.
 */
/**
 * Given two sorted arrays A and B that may have repeated elements. Form a new sorted array C that
 * contains the elements of A and B [Condition : You are not allowed to merge the two arrays and then sort. ]
 * */
public class sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str1 = br.readLine().split(" ");
        String [] str2 = br.readLine().split(" ");
        int size1 = str1.length;
        int size2 = str2.length;
        int []array1= new int[size1];
        int []array2= new int[size2];
        for(int i=0; i<size1; i++){
            array1[i] = Integer.parseInt(str1[i]);
        }
        for(int j=0; j<size2; j++){
            array2[j] =Integer.parseInt(str2[j]);
        }
        int [] result = mergeArray(array1, array2);
        for(int value: result){
            System.out.print(value+" ");
        }
    }
    public static int [] mergeArray(int [] array1, int [] array2){
        int [] result = null;
        if(array1==null && array2==null){
            return result;
        }
        if(array1==null){
            return array2;
        }
        if(array2 ==null){
            return array1;
        }
        int size1= array1.length;
        int size2 = array2.length;
        int k=0, i=0, j=0;
        result = new int[size1+size2];
        while (i<size1 && j<size2){
            if(array1[i]<array2[j]){
                result[k++] = array1[i++];
            }else{
                result[k++] = array2[j++];
            }
        }
        while (i<size1){
            result[k++] = array1[i++];
        }
        while (j<size2){
            result[k++] = array2[i++];
        }
        return result;
    }
}
