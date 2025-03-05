//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            int Arr[] = new int[N];
            String[] inp = read.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                Arr[i] = Integer.parseInt(inp[i]);
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.EvenOddSum(N, Arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> EvenOddSum(int N, int Arr[]) {
        // code here
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList  = new ArrayList<>();
        for(int i=0;i<Arr.length;i++){
            if(i%2==0){
                evenList.add(Arr[i]);
            }else{
                oddList.add(Arr[i]);
            }
        }
        int evenSum=0;
        int oddSum=0;
        for(int n:evenList){
            evenSum+=n;
        }
        for(int n:oddList){
            oddSum+=n;
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(evenSum);
        result.add(oddSum);
        
        return result;
    }
}