//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            System.out.println(solution.smallestSubWithSum(x, arr));

            T--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int l=0;
        int r=0;
        int minLength=Integer.MAX_VALUE;
        int n=arr.length;
        int curSum=0;
        while(r<n){
            curSum=curSum+arr[r];
            while(curSum>x){
                minLength=Math.min(minLength,r-l+1);
                curSum=curSum-arr[l];
                l++;
            }
            r++;
        }
        if(minLength==Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }
}
