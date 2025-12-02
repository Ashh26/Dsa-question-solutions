class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        int maxRight = arr[arr.length-1];
        
        ans.add(maxRight);
        
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>=maxRight){
                maxRight=arr[i];
                ans.add(maxRight);
            }
        }
        
        Collections.reverse(ans);
        
        return ans;
        
    }
}
