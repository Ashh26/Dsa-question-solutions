//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().countCoordinates(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
        private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int countCoordinates(int[][] mat) {
        // code here
        if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;
        
        int m = mat.length, n = mat[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Perform DFS for Pacific Ocean
        for (int i = 0; i < m; i++) {
            dfs(mat, pacific, i, 0);
            dfs(mat, atlantic, i, n - 1);
        }
        
        // Perform DFS for Atlantic Ocean
        for (int j = 0; j < n; j++) {
            dfs(mat, pacific, 0, j);
            dfs(mat, atlantic, m - 1, j);
        }
        
        // Count cells reachable by both oceans
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    count++;
                }
            }
        }
        
        return count;
        
    }
        private void dfs(int[][] mat, boolean[][] visited, int i, int j) {
        int m = mat.length, n = mat[0].length;
        visited[i][j] = true;
        
        for (int[] dir : DIRECTIONS) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
            if (mat[x][y] >= mat[i][j]) {
                dfs(mat, visited, x, y);
            }
        }
    }
}