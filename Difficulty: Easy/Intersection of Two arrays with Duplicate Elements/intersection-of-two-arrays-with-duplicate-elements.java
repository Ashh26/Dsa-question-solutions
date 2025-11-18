class Solution {
    public ArrayList<Integer> intersect(int[] a, int[] b) {
        // code here
        
        // make one resulted arrayList
        ArrayList<Integer> result = new ArrayList<>();
        
        // now add first array element to the hashset sa
        HashSet<Integer> sa = new HashSet<>();
        
        for(int nums:a){
            sa.add(nums);
        }
        
    // now traverse in the second array and then compare it with first array elements.
        // if second array element is present in first array the add that element in
        // the resulted array
        
        for(int nums:b){
            if(sa.contains(nums)){
                result.add(nums);
                sa.remove(nums);
            }
        }
        
        return result;
        
    }
}