//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    int floorSqrt(int n) {
        // Your code here
        if(n==0 || n==1) return n;
        int l=1,r=n,ans=-1;
        while(l<=r){
            int mid=(l+r)>>>1;
            long square = (int)mid*mid;
            if(square==n) return mid;
            if(n<square){
                r=mid-1;
            }else{
                ans=mid;
                l=mid+1;
            }
        }
        return ans;
    }
}
