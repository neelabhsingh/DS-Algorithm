package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by neelabhsingh on 18/12/16.
 */
public class TopKFrequentElements {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] dataStr = br.readLine().split(" ");
        int [] data = new int[dataStr.length];
        int i =0;
        for(String str: dataStr){
            data[i] = Integer.parseInt(str);
            i++;
        }
        //System.out.println(topKFrequent(data, 1));
        System.out.println(topKFrequent_v2(data, 1));
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        Map<Integer, List<Integer>> bucket = new HashMap<>();
        Set keySet = hm.keySet();
        Iterator itr = keySet.iterator();
        while (itr.hasNext()){
            int key = (Integer) itr.next();
            List <Integer> list;
            int value = hm.get(key);
            if(!bucket.containsKey(value)){
                list = new ArrayList<>();
                bucket.put(value, list);
            }else{
                list =bucket.get(value);
            }
            list.add(key);
        }
        List<Integer> result = new ArrayList<>();
        int bucketSize = bucket.size();
        for(int i=bucketSize; i>=1 && result.size()<k; i--){
            if(bucket.containsKey(i)){
                result.addAll(bucket.get(i));
            }
        }
        return result;
    }
    public static List<Integer> topKFrequent_v2(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
