//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] valueInput = br.readLine().trim().split(" ");
            int[] values = new int[valueInput.length];
            for (int i = 0; i < valueInput.length; i++) {
                values[i] = Integer.parseInt(valueInput[i]);
            }
            String[] weightInput = br.readLine().trim().split(" ");
            int[] weights = new int[weightInput.length];
            for (int i = 0; i < weightInput.length; i++) {
                weights[i] = Integer.parseInt(weightInput[i]);
            }
            int w = Integer.parseInt(br.readLine().trim());
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
static class ItemComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            double a1 = (1.0 * a[0]) / a[1];
            double b1 = (1.0 * b[0]) / b[1];
            return Double.compare(b1, a1);
        }
 }

    public static double fractionalKnapsack(int[] values, int[] weights, int capacity) {
         int n = values.length;

        // Create 2D array to store value and weight
        // items[i][0] = value, items[i][1] = weight
        int[][] items = new int[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = values[i];
            items[i][1] = weights[i];
        }

        // Sort items based on value-to-weight ratio in descending order
        Arrays.sort(items, new ItemComparator());

        double res = 0.0;
        int currentCapacity = capacity;

        // Process items in sorted order
        for (int i = 0; i < n; i++) {

            // If we can take the entire item
            if (items[i][1] <= currentCapacity) {
                res += items[i][0];
                currentCapacity -= items[i][1];
            }

            // Otherwise take a fraction of the item
            else {
                res += (1.0 * items[i][0] / items[i][1]) * currentCapacity;

                // Knapsack is full
                break;
            }
        }

        return res;
  }
}