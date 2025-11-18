// User function Template for Java

class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        // add your code here
        
        int n = arr.length;
        if(n==0) return;
        
        d=d%n;
        
        // reverse first d element
        reverse(arr,0,d-1);
        
        // reverse last n-d element
        reverse(arr,d,n-1);
        
        // reverse the whole array element
        reverse(arr,0,n-1);
        
    }
    
    public static void reverse(int[] arr,int i,int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    
}







