//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    
    static int max(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }
    
    static int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
    
    
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        
        int result = arr[0];
        int curMax = arr[0];
        int curMin = arr[0];
        
        for(int i=1;i<arr.length;i++){
            
            int temp = max( arr[i], arr[i]*curMax , arr[i]*curMin );
            
            curMin = min( arr[i], arr[i]*curMax, arr[i]*curMin);
            
            curMax = temp;
            
            result = Math.max(result,curMax);
            
        }
        
        return result;
        
    }
     
}