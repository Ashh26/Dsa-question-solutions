//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            boolean ans =
                ob.hasTripletSum(nums, target); // Call the function and store result
            System.out.println(ans ? "true" : "false"); // Output the result
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Should return true if there is a triplet with sum equal
    // to x in arr[], otherwise false
    public static boolean hasTripletSum(int arr[], int target) {
        Arrays.sort(arr);  // Sort the array

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;  // Skip duplicates
            if (twoSum(arr, target - arr[i], i + 1)) {
                return true;  // Found a valid triplet
            }
        }
        return false;
        // Your code Here
    }
    
   static boolean twoSum(int arr[], int sum, int startFrom) {
        int l = startFrom, r = arr.length - 1;

        while (l < r) {
            int currentSum = arr[l] + arr[r];

            if (currentSum == sum) {
                return true;  // Found a valid pair
            } else if (currentSum < sum) {
                l++;
            } else {
                r--;
            }
        }
        return false;  // No valid pair found
    }
    
}
