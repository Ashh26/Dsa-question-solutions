class Solution {
    static int subArraySum(int arr[], int tar) {
        //  code here
        Map<Integer,Integer> preSum = new HashMap<>();
        
        int count=0;
        int curSum=0;
        
        preSum.put(0,1);
        
        for(int num:arr){
            curSum+=num;
            
            if(preSum.containsKey(curSum-tar)){
                count+=preSum.get(curSum-tar);
            }
            
            preSum.put(curSum,preSum.getOrDefault(curSum,0)+1);
            
        }
        
        return count;
        
    }
}