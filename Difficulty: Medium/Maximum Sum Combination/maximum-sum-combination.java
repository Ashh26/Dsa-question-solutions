//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
      Arrays.sort(A);
        Arrays.sort(B);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Set<String> visited = new HashSet<>();

        int i = N - 1, j = N - 1;
        maxHeap.add(new int[]{A[i] + B[j], i, j});
        visited.add(i + "," + j);

        List<Integer> result = new ArrayList<>();

        while (result.size() < K && !maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            int sum = current[0];
            i = current[1];
            j = current[2];

            result.add(sum);

            // Add (i - 1, j)
            if (i - 1 >= 0) {
                String key1 = (i - 1) + "," + j;
                if (!visited.contains(key1)) {
                    maxHeap.add(new int[]{A[i - 1] + B[j], i - 1, j});
                    visited.add(key1);
                }
            }

            // Add (i, j - 1)
            if (j - 1 >= 0) {
                String key2 = i + "," + (j - 1);
                if (!visited.contains(key2)) {
                    maxHeap.add(new int[]{A[i] + B[j - 1], i, j - 1});
                    visited.add(key2);
                }
            }
        }

        return result;
    }
}
