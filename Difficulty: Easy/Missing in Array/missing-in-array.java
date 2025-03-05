//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().missingNumber(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    int missingNumber(int arr[]) {
        // code here
        int xOr1=arr[0];
        for(int i=1;i<arr.length;i++){
            xOr1=xOr1^arr[i];
        }
        int xOr2=1;
        for(int i=2;i<=arr.length+1;i++){
            xOr2=xOr2^i;
        }
        int result=xOr1^xOr2;
        return result;
    }
}