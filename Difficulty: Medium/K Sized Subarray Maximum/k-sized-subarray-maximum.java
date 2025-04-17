//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            int k = Integer.parseInt(br.readLine());
            ArrayList<Integer> res = new Solution().maxOfSubarrays(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        int i=0;
        while(i<k){
            while(!dq.isEmpty() && dq.getLast()<arr[i]){
                dq.pollLast();
            }
            dq.offerLast(arr[i]);
            i++;
        }
        int n=arr.length;
        int[] ans = new int[n-k+1];
        for(;i<n;i++){
            ans[i-k]=dq.peekFirst();
            if(arr[i-k]==dq.peekFirst()){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && dq.getLast()<arr[i]){
                dq.pollLast();
            }
            dq.offerLast(arr[i]);
        }
        ans[n-k]=dq.peekFirst();
        ArrayList<Integer> list=new ArrayList<>();
        for(int num:ans){
            list.add(num);
        }
        return list;
    }
}