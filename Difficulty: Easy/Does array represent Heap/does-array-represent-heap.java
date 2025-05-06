//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSub(a, n) ? 1:0);
            
        
System.out.println("~");
}
	}
}


// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean countSub(long arr[], long n) {
        // Your code goes here
        return isHeap(arr,(int)n,0);
    }
    
    static boolean isHeap(long[] a,int n,int i){
        if(i>=n/2) return true;
        int left = 2*i+1;
        int right=2*i+2;
        if(a[i]>=a[left] && isHeap(a,n,left)){
            if(right<n){
                return a[i]>=a[right] && isHeap(a,n,right);
            }else{
                return true;
            }
        }
        return false;
    }
    
}