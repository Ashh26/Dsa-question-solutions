//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            int ans = ob.minimumDifference(nums);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minimumDifference(int[] arr) {
        // code here
        int n=arr.length;
        Arrays.sort(arr);
        int minDiff=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            minDiff=Math.min(minDiff,arr[i]-arr[i-1]);
        }
        return minDiff;
    }
}