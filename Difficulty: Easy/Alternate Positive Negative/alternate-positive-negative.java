// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        
        // Add positve and negative element into both arrayList
        
        for(int nums:arr){
            if(nums>=0){
                pos.add(nums);
            }else{
                neg.add(nums);
            }
        }
        
        int posInd=0,negInd=0,i=0;
        
        // Now add all element alternately one by one
       while(posInd<pos.size() && negInd<neg.size()){
           if(i%2==0){
               arr.set(i++,pos.get(posInd++));
           }else{
               arr.set(i++,neg.get(negInd++));
           }
       }
       
       // Now add remaining positive elements
       while(posInd<pos.size()){
           arr.set(i++,pos.get(posInd++));
       }
       
       // Now add remaining negative elements
       while(negInd<neg.size()){
           arr.set(i++,neg.get(negInd++));
       }
       
      
       
    }
}




