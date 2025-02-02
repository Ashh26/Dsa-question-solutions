//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int k) {
        
        int n = arr.length;
        if(n==1) return 0;  // if only one difference, no height difference.
        
        // Now sort the array.
        Arrays.sort(arr);
        
        // Compute the maximum difference.
        int minHeight = arr[0];
        int maxHeight = arr[n-1];
        int result = maxHeight - minHeight;
        
        // Now itereate through the array and then find the minimum difference.
        for(int i = 0;i<n-1;i++){
            int newMin = Math.min(arr[0]+k,arr[i+1]-k);
            int newMax = Math.max(arr[i]+k,arr[n-1]-k);
            
            
            // skip negative height
            if(newMin<0) continue;
            
            
            result = Math.min(result,newMax-newMin);
            
        }
        
        return result;
        
    }
}
