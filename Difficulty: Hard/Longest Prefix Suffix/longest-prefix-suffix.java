//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestPrefixSuffix(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    int longestPrefixSuffix(String s) {
        // code here
        int n=s.length();
        int[] lps = new int[n];
        int pre=0;
        int suf=1;
        
        while(suf<n){
            if(s.charAt(suf)==s.charAt(pre)){
                pre++;
                lps[suf]=pre;
                suf++;
            }else{
                if(pre==0){
                    suf++;
                }else{
                    pre=lps[pre-1];
                }
            }
        }
        return lps[n-1];
    }
}



