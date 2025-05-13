//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.canRepresentBST(arr, N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int canRepresentBST(int arr[], int N) {
        // code here
         Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            // If we find a node which is on the left and smaller than root, return 0
            if (arr[i] < root) {
                return 0;
            }

            // Keep removing elements smaller than current one
            // which means current node is in right subtree of last popped node
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                root = stack.pop();
            }

            // Push current element
            stack.push(arr[i]);
        }

        return 1;
    }
}