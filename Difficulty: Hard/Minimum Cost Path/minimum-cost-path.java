//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;

        // Directions for moving in the grid (left, right, up, down)
        int[] directions = {-1, 0, 1, 0, 0, -1, 0, 1};

        // Priority queue to store cells along with their costs
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, grid[0][0]}); // Starting point (row, col, cost)

        // 2D array to keep track of minimum cost to reach each cell
        int[][] minCost = new int[n][m];
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minCost[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int cost = current[2];

            if (x == n - 1 && y == m - 1) {
                return cost;
            }


            for (int i = 0; i < 4; i++) {
                int newX = x + directions[i * 2];
                int newY = y + directions[i * 2 + 1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    int newCost = cost + grid[newX][newY];

                    if (newCost < minCost[newX][newY]) {
                        minCost[newX][newY] = newCost;
                        pq.offer(new int[]{newX, newY, newCost});
                    }
                }
            }
        }

        return -1;
    }
}