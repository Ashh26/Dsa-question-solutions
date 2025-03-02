//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRemoval(int intervals[][]) {
        // code here
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        int count = 0;
        
        int i=0;
        int j=1;
        int n = intervals.length;
        
        while(j<n){
            int cs = intervals[i][0];
            int ce = intervals[i][1];
            
            int ns = intervals[j][0];
            int ne = intervals[j][1];
            
            if(ce<=ns){ // no overlapping
                i=j;
                j++;
            }else if(ce<=ne){    // overlapping
                j++;
                count++;
            } else if(ce>ne){   // overlapping
                i=j;
                j++;
                count++;
            }
        }
        return count;
    }
}
