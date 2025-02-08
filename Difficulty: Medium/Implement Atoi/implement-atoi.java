//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int myAtoi(String s) {
        // ensute the input string is not null
        if(s==null){
            return 0;
        }
        
        int length = s.length();
        int index = 0;
        
        // skip whitespaces characters
        while(index<length && s.charAt(index)==' '){
            index++;
        }
        
        // if we reached the end ofsign after skipping spaces, return 0
        if(index==length){
            return 0;
        }
        
        // determine the sign bases on the current character
        int sign=1;
        
        if(s.charAt(index)=='-'){
            sign=-1;
            index++;
        }else if(s.charAt(index)=='+'){
            index++;
        }
        
        int result = 0;
        
        // pre-calculate the threshold to check for overflow
        int threshold=Integer.MAX_VALUE/10;
        
        // convert the number
        while(index<length){
            char currentChar = s.charAt(index);
            
            // break if the current character is not a digit
            if(currentChar<'0' || currentChar>'9'){
                break;
            }
            
            // check for overflow when adding a new digit
            if(result>threshold || (result==threshold && currentChar>'7')){
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            // update the result with the new digit
            result = result*10+(currentChar-'0');
            index++;
        }
        
        // apply the deternmined sign to the result and return
        return result*sign;
        
    }
}







