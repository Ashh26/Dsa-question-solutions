//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public int maxPartitions(int[] arr) {
        // code here
        if(arr.length==0) return 0;
        int n=arr.length;
        int chunks=0;
        int maxSoFar=0;
        
        for(int i=0;i<n;i++){
            maxSoFar=Math.max(maxSoFar,arr[i]);
            if(i==maxSoFar){
                chunks++;
            }
        }
        return chunks;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
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
            Solution obj = new Solution();
            int res = obj.maxPartitions(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends