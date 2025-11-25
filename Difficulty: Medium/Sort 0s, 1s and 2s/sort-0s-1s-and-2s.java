class Solution {
    
    public static void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
    public void sort012(int[] arr) {
        // code here
        int leftBoundry = -1;
        int rightBoundry = arr.length;
        int current = 0;
        
        while(current<rightBoundry){
            if(arr[current]==0){
                leftBoundry++;
                swap(arr,leftBoundry,current);
                current++;
            }else if(arr[current]==2){
                rightBoundry--;
                swap(arr,rightBoundry,current);
            }else{
                current++;
            }
        }
        
    }
}