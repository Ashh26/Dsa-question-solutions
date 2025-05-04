//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        HashMap<Character,Integer> map=new HashMap<>();
        int l=0,r=0;
        int ans=0;
        while(r<s.length()){
            if(!map.containsKey(s.charAt(r)) || map.get(s.charAt(r))<l){
                ans = Math.max(ans,r-l+1);
            }else{
                l=map.get(s.charAt(r))+1;
            }
            map.put(s.charAt(r),r);
            r++;
        }
        return ans;
    }
}