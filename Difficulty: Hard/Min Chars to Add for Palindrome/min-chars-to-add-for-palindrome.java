//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public static int minChar(String s) {
        // first reverse a string
        StringBuilder reverse = new StringBuilder(s).reverse();
        
        String combined = s+'$'+reverse;
        int combinedLength = combined.length();
        int inputSize = s.length();
        
        int[] lps = new int[combinedLength];
        int pre=0;
        int suf=1;
        
        
        while( suf < combinedLength) {
            
            if(combined.charAt(suf)==combined.charAt(pre)){
                pre++;
                lps[suf]=pre;
                suf++;
                
            }else{
                if(pre==0){
                    suf++;
                }else{
                    pre=lps[pre-1];
                }
            }
        }
        return inputSize-lps[combinedLength-1];
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        var sc = new FastReader();
        int test = sc.nextInt();
        while (test-- > 0) {
            String s = sc.nextString();
            System.out.println(Solution.minChar(s));

            System.out.println("~");
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private void read() throws IOException {
            st = new StringTokenizer(br.readLine());
        }

        public String nextString() throws IOException {
            while (!st.hasMoreTokens()) read();
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextString());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextString());
        }
    }
}
// } Driver Code Ends