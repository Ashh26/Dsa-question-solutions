class Solution {
    public ArrayList<Integer> getMinMax(int[] arr) {
        // code Here
        ArrayList<Integer> sortedarr = new ArrayList<>();
        
        // adding all the arr element in the arrayList
        for(int nums:arr){
            sortedarr.add(nums);
        }
        
        // Now sort the new arraylist using Collections
        Collections.sort(sortedarr);
        
        // now make new arrayList of name result and add first and last element of 
        // sortedarr in the result 
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(sortedarr.get(0));
        result.add(sortedarr.get(sortedarr.size()-1));
        
        return result;
        
    }
}
