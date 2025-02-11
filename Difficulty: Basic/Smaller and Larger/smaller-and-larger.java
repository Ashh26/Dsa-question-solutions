//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] strNumbers = input.split(" ");
            int[] arr = new int[strNumbers.length];
            for (int i = 0; i < strNumbers.length; i++) {
                arr[i] = Integer.parseInt(strNumbers[i]);
            }
            int x = Integer.parseInt(sc.nextLine()); // consume the newline
            int[] ans = new Solution().getMoreAndLess(arr, x);
            System.out.println(ans[0] + " " + ans[1]);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] getMoreAndLess(int[] arr, int target) {
        // code here
        int lessEqual=0;
        int greaterEqual=0;
        
        int[] result = new int[2];
        
        for(int i=0;i<arr.length;i++){
            if(target<=arr[i]){
                lessEqual++;
                result[1] = lessEqual;
            }
            
            if(target>=arr[i]){
                greaterEqual++;
                result[0]=greaterEqual;
            }
        }
        
        return result;
    }
}