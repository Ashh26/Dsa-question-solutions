//{ Driver Code Starts


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.isPrime(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




class Solution
{
    public int isPrime(int N)
    {
            int count=0;
        for(int i=2;i<N;i++){
            if(N%i==0){
                count++;
            }
        }
        
        if(count==0 && N!=1){
            return 1;
        }else{
            return 0;
        }

    }
}