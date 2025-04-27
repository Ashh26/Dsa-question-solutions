//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int n = input_line.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int low = getMax(arr);
        int high = getSum(arr);
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(arr, k, mid)) {
                ans = mid;         // Possible, try to minimize more
                high = mid - 1;
            } else {
                low = mid + 1;     // Not possible, try bigger
            }
        }
        
        return ans;
    }
    
    private static int getMax(int[] boards) {
        int max = boards[0];
        for (int board : boards) {
            max = Math.max(max, board);
        }
        return max;
    }
    
    private static int getSum(int[] boards) {
        int sum = 0;
        for (int board : boards) {
            sum += board;
        }
        return sum;
    }
    
    private static boolean isPossible(int[] boards, int k, int maxTime) {
        int painters = 1;
        int currentSum = 0;
        
        for (int board : boards) {
            if (currentSum + board > maxTime) {
                painters++;
                currentSum = board;
                
                if (painters > k) {
                    return false;
                }
            } else {
                currentSum += board;
            }
        }
        
        return true;
    }
}
