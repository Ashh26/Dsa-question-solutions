//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            // Case 1: current prefix sum equals target
            if (currSum == target) {
                result.add(1);         // 1-based indexing
                result.add(i + 1);
                return result;
            }

            // Case 2: (currSum - target) seen before => subarray found
            if (prefixSumMap.containsKey(currSum - target)) {
                result.add(prefixSumMap.get(currSum - target) + 2); // +2 to convert 0-based to 1-based
                result.add(i + 1);
                return result;
            }

            // Store current prefix sum and index if not already present
            if (!prefixSumMap.containsKey(currSum)) {
                prefixSumMap.put(currSum, i);
            }
        }

        // No subarray found
        result.add(-1);
        return result;
    }
}
