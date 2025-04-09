//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int n=arr.length;
        int[] left = smallerOnLeft(arr);
        int[] right = smallerOnRight(arr);
        
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MIN_VALUE);
        
        for(int i=0;i<n;i++){
            int wl=right[i]-left[i]-1;
            ans[wl-1]=Math.max(ans[wl-1],arr[i]);
        }
        
        for(int i=n-2;i>=0;i--){
            ans[i]=Math.max(ans[i],ans[i+1]);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            result.add(ans[i]);
        }
        
        return result;
    }
    
    static int[] smallerOnLeft(int[] a){
        int n=a.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ans=new int[n];
        
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && a[stack.peek()]>=a[i]){
                stack.pop();
            }
            ans[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return ans;
    }
    
    static int[] smallerOnRight(int[] a){
        int n=a.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ans=new int[n];
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











