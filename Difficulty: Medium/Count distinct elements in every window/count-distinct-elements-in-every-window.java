//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
         int n = arr.length;
        int[] ans = new int[n - k + 1];
        Map<Integer, Integer> map = new HashMap<>();

        // Initialize frequency map with the first window
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Slide the window
        for (int i = k; i < n; i++) {
            ans[i - k] = map.size(); // store distinct count before modifying the map

            int left = i - k;
            int right = i;

            // Remove the frequency of the outgoing element
            int freqLeft = map.get(arr[left]);
            if (freqLeft == 1) {
                map.remove(arr[left]);
            } else {
                map.put(arr[left], freqLeft - 1);
            }

            // Add/increment the incoming element
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
        }

        // Add the count for the last window
        ans[n - k] = map.size();

        // Convert to ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : ans) {
            list.add(num);
        }

        return list;
    }
}







