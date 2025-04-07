//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    
    static boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    
    public int evaluate(String[] arr) {
        // code here
        int n=arr.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(String token:arr){
            if(isOperator(token)){
                int second=stack.pop();
                int first = stack.pop();
                int result=0;
                switch(token){
                    case "+":
                        result=first+second;
                        break;
                    case "-":
                        result=first-second;
                        break;
                    case "*":
                        result=first*second;
                        break;
                    case "/":
                        result=first/second;
                        break;
                }
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends