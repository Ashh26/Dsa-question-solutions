//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isFactorial(N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isFactorial(int n) {
        for(int i=1;;i++){
            if(n%i==0){
                n = n/i;
            }else{
                break;
            }
        }
        
        if(n==1){
            return 1;
        }else{
            return 0;
        }
        
    }
}