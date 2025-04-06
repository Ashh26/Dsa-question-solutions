//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static boolean isBalanced(String s) {
        // code here
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            
            if(cur=='(' || cur=='[' || cur=='{'){
                stack.push(cur);
            }else{
                if(stack.isEmpty()) return false;
                char opening = stack.pop();
                if((opening=='(' && cur==')') 
                || (opening=='[' && cur==']') 
                || (opening=='{' && cur=='}')) continue;
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
