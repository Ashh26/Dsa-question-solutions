//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int M) {
        // code here
        int N=arr.length;
          if (M > N) return -1;  // Not enough books
        
        int low = getMax(arr);
        int high = getSum(arr);
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, N, M, mid)) {
                ans = mid;         // Found a possible answer, try smaller
                high = mid - 1;
            } else {
                low = mid + 1;     // Not possible, try bigger
            }
        }
        
        return ans;
    }
    
    private static int getMax(int[] A) {
        int max = A[0];
        for (int num : A) {
            max = Math.max(max, num);
        }
        return max;
    }
    
    private static int getSum(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        return sum;
    }
    
    private static boolean isPossible(int[] A, int N, int M, int maxPages) {
        int students = 1;
        int pages = 0;
        
        for (int i = 0; i < N; i++) {
            if (pages + A[i] > maxPages) {
                students++;
                pages = A[i];
                
                if (students > M) {
                    return false;
                }
            } else {
                pages += A[i];
            }
        }
        
        return true;
    }
}