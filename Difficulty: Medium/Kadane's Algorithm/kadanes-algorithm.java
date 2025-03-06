//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
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

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    int maxSubarraySum(int[] arr) {
                int maxEnding = arr[0];
        int result = arr[0];
        
        
        for(int i=1;i<arr.length;i++){
            
            // find maximum sum, ending at index i by either extending 
        //the maximum subarray ending at i-1 or by starting a new subarray from index i.
                maxEnding = Math.max(maxEnding+arr[i],arr[i]);
                
            
            // update result if maximum subarray sum ending at index i >result;    
            
                result = Math.max(result,maxEnding);
            
        }
        return result;
    }
}



