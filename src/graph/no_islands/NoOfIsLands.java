package graph.no_islands;

/**
 * Created by neelabhsingh on 15/01/17.
 */
/**
* http://www.geeksforgeeks.org/find-number-of-islands/
*/

public class NoOfIsLands {
    public static void main(String[] args) {
        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        IsLands I = new IsLands();
        System.out.println("Number of islands is: "+ I.countIslands(M));
    }
}
