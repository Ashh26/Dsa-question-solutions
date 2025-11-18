class Solution {
    public void rotateclockwise(int[] arr, int k) {
        // code here
        
        int n = arr.length;
        if(n==0) return;
        
        // if the k value is bigger than the array size n
        k = k%n;
        int i,j;
        
        // reverse last k element
        for(i = n-k, j=n-1; i<j; i++, j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        // then reverse first n-k element
        for(i=0, j=n-k-1; i<j; i++, j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        // finally reverse the whole array
        for(i=0, j=n-1; i<j; i++, j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
    }
}