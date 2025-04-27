//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
// import java.util.*;

class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // First, sort the stall positions
        
        int low = 1;  // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canPlaceCows(stalls, k, mid)) {
                ans = mid;      // Try for a bigger minimum distance
                low = mid + 1;
            } else {
                high = mid - 1; // Try for a smaller minimum distance
            }
        }
        
        return ans;
    }
    
    private static boolean canPlaceCows(int[] stalls, int k, int minDist) {
        int cowsPlaced = 1;
        int lastPosition = stalls[0];
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                cowsPlaced++;
                lastPosition = stalls[i];
            }
        }
        
        return cowsPlaced >= k;
    }
}
