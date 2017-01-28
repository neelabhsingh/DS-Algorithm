package leetcode.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by neelabhsingh on 09/01/17.
 */
public class BalanceParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> result = generateParenthesis(n);
        Iterator itr = result.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public static List<String> generateParenthesis(int n){
        List<String> parenthesisList= new ArrayList<>();
        String parenthesis = "";
        _printParenthesis_v2(0, n, 0, 0, parenthesis, parenthesisList);
        return parenthesisList;
    }
    public static void _printParenthesis_v1(int pos, int n, int open, int close, String parenthesis, List<String> parenthesisList){
        if(close == n){
            parenthesisList.add(parenthesis);
        }else {
            if(open>close){
                _printParenthesis_v1(pos+1, n, open, close+1, parenthesis+")", parenthesisList);
            }
            if(open<n){
                _printParenthesis_v1(pos+1, n, open+1, close, parenthesis+"(", parenthesisList);
            }
        }

    }
    public static void _printParenthesis_v2(int pos, int n, int open, int close, String parenthesis, List<String> parenthesisList){
        if(close == n){
            parenthesisList.add(parenthesis);
        }else {

            if(open<n){
                _printParenthesis_v2(pos+1, n, open+1, close, parenthesis+"(", parenthesisList);
            }
            if(open>close){
                _printParenthesis_v2(pos+1, n, open, close+1, parenthesis+")", parenthesisList);
            }
        }

    }
}
