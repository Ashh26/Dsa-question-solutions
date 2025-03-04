//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[(int)(n)];
            for (int i = 0; i < n; i++) {
                arr[i] = (int)(Long.parseLong(inputLine[i]));
            }

            Solution obj = new Solution();
            int[] product = obj.minAnd2ndMin(arr);
            if (product[0] == -1)
                System.out.println(product[0]);
            else
                System.out.println(product[0] + " " + product[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] minAnd2ndMin(int arr[]) {
        // code here
        int smallest = Integer.MAX_VALUE;
        int second_smallest = Integer.MAX_VALUE;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]<smallest){
                second_smallest=smallest;
                smallest = arr[i];
            }else if(arr[i]<second_smallest && arr[i]>smallest){
                second_smallest = arr[i];
            }
        }
        if(smallest!=Integer.MAX_VALUE && second_smallest!=Integer.MAX_VALUE){
            int[] a = new int[]{smallest,second_smallest};
            return a;
        }
        return new int[]{-1,-1};
    }
}
