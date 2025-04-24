//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        int fo=firstOccurence(arr,x);
        int lo=lastOccurence(arr,x);
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(fo);
        ans.add(lo);
        return ans;
    }
    
    public static int firstOccurence(int[] a,int k){
        int l=0;
        int r=a.length-1;
        int ans=-1;
        while(l<=r){
            int m=(l+r)>>>1;
            if(k<a[m]){
                r=m-1;
            }else if(k>a[m]){
                l=m+1;
            }else{
                r=m-1;
                ans=m;
            }
        }
        return ans;
    }
    
    public static int lastOccurence(int[] a,int k){
        int l=0;
        int r=a.length-1;
        int ans=-1;
        while(l<=r){
            int m=(l+r)>>>1;
            if(k<a[m]){
                r=m-1;
            }else if(k>a[m]){
                l=m+1;
            }else{
                l=m+1;
                ans=m;
            }
        }
        return ans;
    }
    
}










//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            int x = Integer.parseInt(br.readLine());
            GFG ob = new GFG();
            ArrayList<Integer> ans = ob.find(arr, x);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends