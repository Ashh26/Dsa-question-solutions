class Solution {
    int countPairs(int arr[], int target) {
        // code here
        
        Map<Integer,Integer> freq = new HashMap<>();
        int count=0;
        
        for(int i=0;i<arr.length;i++){
            if(freq.containsKey(target-arr[i])){
                count = count+freq.get(target-arr[i]);
            }
            
            freq.put(arr[i],freq.getOrDefault(arr[i],0)+1);
        }
        
        return count;
        
    }
}