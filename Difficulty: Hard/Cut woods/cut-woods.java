//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int M; 
            M = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.maxHeight(N, A, M);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxHeight(int N, int[] A, int M) {
        // code here
        int l = 0, h = (int) 1e9;
        int ans = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            int totalWoodLength = getWoodAtCut(A, m); // use m not M

            if (totalWoodLength >= M) {
                ans = m;      // valid height, try for even bigger cut
                l = m + 1;
            } else {
                h = m - 1;    // not enough wood, decrease cut height
            }
        }
        return ans;
    }

    static int getWoodAtCut(int[] a, int cut) {
        int ans = 0;
        for (int e : a) {
            if (e > cut) {
                ans += e - cut;
            }
        }
        return ans;
    }
}
