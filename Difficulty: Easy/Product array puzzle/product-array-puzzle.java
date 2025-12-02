// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int ans[] = new int[arr.length];
        
        int left=1;
        int right=1;
        
        for(int i=0;i<arr.length;i++){
            ans[i]=left;
            left*=arr[i];
        }
        
        for(int i=arr.length-1;i>=0;i--){
            ans[i]*=right;
            right*=arr[i];
        }
        
        return ans;
        
    }
}
