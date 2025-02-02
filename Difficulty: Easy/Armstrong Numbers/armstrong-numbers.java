//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            boolean flag = ob.armstrongNumber(n);
            if (flag) {
                System.out.println("true");

            } else {
                System.out.println("false");
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static boolean armstrongNumber(int n) {
        int temp1 = n;
        int digit=0;
        
        
        while(temp1!=0){
            temp1 = temp1/10;
            digit++;
        }
        
        int reminder;
        int reverse = 0;
        int temp2 = n;
        int mul;
        
        while(temp2!=0){
            reminder = temp2%10;
            mul=1;
            
            for(int i=1;i<=digit;i++){
                mul = mul * reminder;
            }
            reverse = reverse+mul;
            temp2=temp2/10;
            
        }
        
       if(n==reverse){
           return true;
       }else{
           return false;
       }
        
        
    }
}