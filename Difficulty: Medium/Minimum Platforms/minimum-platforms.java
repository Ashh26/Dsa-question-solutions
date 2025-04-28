//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                    Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                    Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
   static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;

        // Step 1: Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // Step 2: Initialize pointers and variables
        int platforms = 1; // at least one platform is needed
        int result = 1; // stores the maximum platforms needed at any time
        int i = 1; // pointer for arrival times
        int j = 0; // pointer for departure times

        // Step 3: Traverse the arrays
        while (i < n && j < n) {
            // If the next train arrives before the next one departs
            if (arr[i] <= dep[j]) {
                platforms++; // need one more platform
                i++; // move to the next arrival
            }
            // If a train departs before the next train arrives
            else {
                platforms--; // free one platform
                j++; // move to the next departure
            }
            // Update the result if needed
            result = Math.max(result, platforms);
        }

        return result; // return the maximum platforms needed at any time
    }
}
