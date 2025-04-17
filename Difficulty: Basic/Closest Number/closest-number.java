//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            int M = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.closestNumber(N, M));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int closestNumber(int n, int m) {
        // code here
        int q=n/m;
        int n1=m*q;
        int n2=(n*m)>0 ? m*(q+1):m*(q-1);
        if(Math.abs(n-n1)<Math.abs(n-n2)){
            return n1;
        }
        return n2;
    }
};