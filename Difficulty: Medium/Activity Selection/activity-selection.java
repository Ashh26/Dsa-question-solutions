//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            int[] start = new int[startInput.length];
            for (int i = 0; i < startInput.length; i++) {
                start[i] = Integer.parseInt(startInput[i]);
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            int[] finish = new int[endInput.length];
            for (int i = 0; i < endInput.length; i++) {
                finish[i] = Integer.parseInt(endInput[i]);
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, finish));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
     public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        
        // Step 1: Create an array of indexes 0 to n-1
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        // Step 2: Sort indexes according to finish times
        Arrays.sort(indexes, (i, j) -> Integer.compare(finish[i], finish[j]));

        // Step 3: Select activities
        int count = 0;
        int lastFinish = -1;

        for (int idx : indexes) {
            if (start[idx] > lastFinish) {
                count++;
                lastFinish = finish[idx];
            }
        }

        return count;
    }
}
