//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driver {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String arr1[] = br.readLine().split(" ");
            int[] a = new int[arr1.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);

            String arr2[] = br.readLine().split(" ");
            int[] b = new int[arr2.length];

            for (int i = 0; i < arr2.length; i++) b[i] = Integer.parseInt(arr2[i]);

            if (b.length == 1 && b[0] == 0) {
                b = new int[0];
            }
            double res = new Solution().medianOf2(a, b);

            if (res == (int)res)
                System.out.println((int)res);
            else
                System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public double medianOf2(int a[], int b[]) {
        // Your Code Here
        int n1 = a.length, n2 = b.length;
        int n = n1 + n2;
        int left = (n + 1) / 2;

        if (n1 > n2) return medianOf2(b, a);

        int l = 0, r = n1;

        while (l <= r) {
            int m1 = (l + r) / 2;
            int m2 = left - m1;
            int l1 = m1 <= 0 ? Integer.MIN_VALUE : a[m1 - 1];
            int l2 = m2 <= 0 ? Integer.MIN_VALUE : b[m2 - 1];
            int r1 = m1 >= n1 ? Integer.MAX_VALUE : a[m1];
            int r2 = m2 >= n2 ? Integer.MAX_VALUE : b[m2];

            if (l1 <= r2 && l2 <= r1) { // found the median position
                if (n % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                r = m1 - 1;
            } else if (l2 > r1) {
                l = m1 + 1;
            }
        }
        return 0;  
    }
}