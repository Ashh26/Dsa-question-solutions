//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {
        int totalSum=0;
        int curMaxSum=0;
        int curMinSum=0;
        int maxSum=arr[0];
        int minSum=arr[0];
        
        for(int i=0;i<arr.length;i++){
            
            // kadane's algorithm to find maximum sum subarray
            curMaxSum = Math.max(curMaxSum+arr[i],arr[i]);
            maxSum = Math.max(maxSum,curMaxSum);
            
            // kadane's algorithm to find minimum sum subarray
            curMinSum = Math.min(curMinSum+arr[i],arr[i]);
            minSum = Math.min(minSum,curMinSum);
            
            // sum of all the element in the input array
            totalSum = totalSum+arr[i];
            
        }
        
        int normalSum=maxSum;
        int circularSum=totalSum-minSum;
        
        
        // if the minSum subarray is equal to totalSum subarray
        // then we just need to return normalSum array
        if(minSum==totalSum){
            return normalSum;
        }
        
        
        return Math.max(normalSum,circularSum);
        
        
        
    }
}
