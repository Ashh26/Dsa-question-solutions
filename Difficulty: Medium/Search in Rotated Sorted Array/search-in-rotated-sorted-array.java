//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
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

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(int[] nums, int target) {
       int l = 0;
    int r = nums.length - 1;
    int result = -1;

    while (l <= r) {
      int m = (l + r) >>> 1;

      if (target == nums[m]) {
        result = m;      // store the index
        r = m - 1;       // continue searching on the left side
      } else if (nums[m] == nums[l] && nums[m] == nums[r]) {
        l++;
        r--;
      } else if (nums[l] <= nums[m]) {
        if (nums[l] <= target && target < nums[m]) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      } else {
        if (nums[m] < target && target <= nums[r]) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      }
    }

    return result;
    }
}