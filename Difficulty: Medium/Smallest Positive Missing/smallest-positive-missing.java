//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // Read the line of integers (prices)
            String input = br.readLine().trim();

            // Split the input line into integers and store in an array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the missingNumber method
            int res = ob.missingNumber(arr);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            
            // if arr[i] is in the range of [1,n]
            // and if arr[i] is not placed in (arr[i]-1)th index
            while(arr[i]>=1 && arr[i]<=n-1 && arr[i]!=arr[arr[i]-1]){
                
            // Now then swap the arr[i] to arr[arr[i]-1]  to 
            // place arr[i] to it's corresponding index
                int temp = arr[i];
                arr[i] = arr[arr[i]-1];
                arr[temp-1] = temp;
            }
            
        }
             // if number is not in the corresponding index
            // so that number is the missing number.
              // [1,2,-3,4,1,7]
            for(int i=1;i<=n;i++){
                if(i!=arr[i-1]){   // for i=3   3!= -3
                    return i;     //  3
                }
            }
            
            // if all the number from i to n is present in the given array
            // then n+1 is the smallest positive missing number
            // return n+1;
            return n+1;
    }
}
