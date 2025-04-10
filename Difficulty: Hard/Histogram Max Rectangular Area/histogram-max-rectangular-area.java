//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static int getMaxArea(int arr[]) {
        int n=arr.length;
        int[] ps=preSmaller(arr);
        int[] ns=nextSmaller(arr);
        
        int max=0;
        
        for(int i=0;i<n;i++){
            int cur=(ns[i]-ps[i]-1)*arr[i];
            max = Math.max(max,cur);
        }
        return max;
    }
    static int[] preSmaller(int[] a){
        int n=a.length;
        int[] ans=new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && a[stack.peek()]>=a[i]){
                stack.pop();
            }
            ans[i]=stack.isEmpty() ? -1:stack.peek();
            stack.push(i);
        }
        return ans;
    }
    
    static int[] nextSmaller(int[] a){
        int n=a.length;
        int[] ans=new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && a[stack.peek()]>=a[i]){
                stack.pop();
            }
            ans[i]=stack.isEmpty() ? n:stack.peek();
            stack.push(i);
        }
        return ans;
    }
    
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends