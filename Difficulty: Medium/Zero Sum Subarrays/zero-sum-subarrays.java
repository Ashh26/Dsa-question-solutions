//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline

        while (t-- > 0) {
            String input = sc.nextLine(); // Input array as a space-separated string
            String[] inputArray = input.split(" ");
            int[] arr = new int[inputArray.length];

            // Parse the input array
            for (int i = 0; i < inputArray.length; i++) {
                arr[i] = Integer.parseInt(inputArray[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findSubarray(arr));
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public int findSubarray(int[] arr) {
        // code here.
           Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int cs = 0;
        map.put(0, 1); // To handle the case where subarray from index 0 has sum 0

        for (int e : arr) {
            cs += e;

            // If cs is already in map, there exist one or more subarrays with sum 0
            count += map.getOrDefault(cs, 0);

            // Update the frequency of this cumulative sum
            map.put(cs, map.getOrDefault(cs, 0) + 1);
        }

        return count;
    }
}
