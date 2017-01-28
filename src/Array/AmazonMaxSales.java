package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by neelabhsingh on 26/12/16.
 */
public class AmazonMaxSales {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        ArrayList<ProductPrice> arrayList = new ArrayList<>();
        for(int i =0; i<n;i++){
            String [] productInfo = br.readLine().split(" ");
            int startTime = Integer.parseInt(productInfo[0]);
            int finishTime = Integer.parseInt(productInfo[1]);
            int price = Integer.parseInt(productInfo[2]);
            arrayList.add(new ProductPrice(startTime, finishTime, price));
        }
        Collections.sort(arrayList);
        ArrayList<ProductPrice> result = getMaxPriceSales(arrayList);
        Iterator itr = result.iterator();
        while (itr.hasNext()){
            ProductPrice p = (ProductPrice) itr.next();
            System.out.println(p.getStartTime()+" "+p.getFinishTime()+" "+p.getPrice());
        }
    }
    public static ArrayList<ProductPrice> getMaxPriceSales(ArrayList<ProductPrice> arrayList){
        for(int i=0 ; i<arrayList.size()-1; i++){
            ProductPrice p1 = arrayList.get(i);
            ProductPrice p2 = arrayList.get(i+1);
            if(p1.getFinishTime() > p2.getStartTime()){
                if (p1.getPrice() > p2.getPrice()){
                    p1.setFinishTime(p2.getStartTime()-1);
                }else if(p1.getPrice() < p2.getPrice()){
                    p2.setStartTime(p1.getFinishTime()+1);
                }
            }else{
                if(p1.getFinishTime() +1< p2.getStartTime()){
                    ProductPrice newProduct = new ProductPrice(p1.getFinishTime()+1, p2.getStartTime()-1, 0);
                    arrayList.add(i+1, newProduct);
                    i= i+1;
                }
            }
        }
        return arrayList;
    }
}
class ProductPrice implements Comparable<ProductPrice>{
    private int startTime;
    private int finishTime;
    private int price;

    public int getStartTime() {
        return startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public int getPrice() {
        return price;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public ProductPrice(int startTime, int finishTime, int price) {
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.price = price;
    }

    @Override
    public int compareTo(ProductPrice product) {
        return this.getFinishTime() - product.getFinishTime();
    }
}