//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        HashSet<Integer> hs = new HashSet<>();
        for(int num:arr){
            hs.add(num);
        }
        
        int result=0;
        
        for(int i=0;i<arr.length;i++){
            if(!hs.contains(arr[i]-1)){
                int num=arr[i];
                
                while(hs.contains(num))
                {
                   num++;
                }
                
                if(result<num-arr[i]){
                result=num-arr[i];
                }
            }
        }
        return result;
    }
}