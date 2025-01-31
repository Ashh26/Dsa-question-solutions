//{ Driver Code Starts
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        Solution ob = new Solution();

        while (T-- > 0) {
            int n = sc.nextInt();
            boolean ans = ob.isPalindrome(n);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public boolean isPalindrome(int n) {
        int reverse=0,reminder,temp=n;
        while(temp>0){
            reminder = temp%10;   // temp=123,reminder=3
            reverse = reverse*10 + reminder;  // 0*10+3
            temp = temp/10;      // quotioned = 12
         }
         
         return reverse==n && n>=0;
         
    }
}