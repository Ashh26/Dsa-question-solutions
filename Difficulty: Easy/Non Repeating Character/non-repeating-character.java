//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // store the length of the character in n
        int n = s.length();
        
        // first loop for pick one char at one time
        for(int i=0;i<n;i++){
            // in every iteration found will be false after second loop is fasle is true then all the character is repeated
            boolean found = false;
            
            // second loop for comparing each character to every character
            for(int j=0;j<n;j++){
                // check if character is repeated or not
                if(i!=j && s.charAt(i)==s.charAt(j)){
                    found = true;
                    break;
                }
            }
            // check if found is false after second loop means there is no any repeated character
            if(found==false){
                return s.charAt(i); // returning the charcter
            }
            
        }
        
        
        return '$'; // is all is repeated character then return '$'
    }
}
