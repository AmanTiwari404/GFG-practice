//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
         int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] effort = new int[rows][columns];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // {effort, row, col}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentEffort = current[0];
            int x = current[1];
            int y = current[2];

            if (x == rows - 1 && y == columns - 1) {
                return currentEffort;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < columns) {
                    int newEffort = Math.max(currentEffort, Math.abs(heights[x][y] - heights[newX][newY]));
                    if (newEffort < effort[newX][newY]) {
                        effort[newX][newY] = newEffort;
                        pq.offer(new int[]{newEffort, newX, newY});
                    }
                }
            }
        }

        return 0; // This line is theoretically unreachable because we should return inside the loop.
    }
}
