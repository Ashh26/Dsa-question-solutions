class Solution {
    public int missingNumber(int[] arr) {
        // code here
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            while(arr[i]>0 && arr[i]<=n && arr[i]!=arr[arr[i]-1]){
                int j = arr[i]-1;
                swap(arr,i,j);
            }
        }
        
        
        for(int i=0;i<n;i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        
        
        return n+1;
        
    }
    
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
