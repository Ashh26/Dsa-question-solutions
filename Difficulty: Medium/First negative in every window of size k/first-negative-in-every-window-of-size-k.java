//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        int i=0;
        while(i<k){
        if(arr[i]<0){
            dq.offerLast(arr[i]);
        }
        i++;
        }
        int n=arr.length;
        int[] ans= new int[n-k+1];
        for(;i<n;i++){
            if(dq.isEmpty()){
                ans[i-k]=0;
            }else{
                ans[i-k]=dq.peekFirst();
            }
            
            if(!dq.isEmpty() && dq.peekFirst()==arr[i-k]){
                dq.pollFirst();
            }
            
            if(arr[i]<0){
                dq.offerLast(arr[i]);
            }
        }
        if(dq.isEmpty()){
            ans[n-k]=0;
        }else{
            ans[n-k]=dq.peekFirst();
        }
        List<Integer> list = new ArrayList<>();
        for(int num:ans){
            list.add(num);
        }
        return list;
    }
}





//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

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
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            List<Integer> ans = ob.firstNegInt(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends