class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        
        ArrayList<Integer> result = new ArrayList<>();
        int n=a.length;
        int m=b.length;
        
        // initialize i and j with 0;
        int i=0,j=0;
        while(i<n && j<m){
            
            // Skip duplicates of first array
            if(i>0 && a[i-1]==a[i]){
                i++;
                continue;
            }
            
            // Similarily skip duplicates of second array
            if(j>0 && b[j-1]==b[j]){
                j++;
                continue;
            }
            
            // now pick smaller element then move forward i by 1
            
            if(a[i]<b[j]){
                result.add(a[i]);
                i++;
            }else if(b[j]<a[i]){
                
                // if b[] has smaller element then a[] so add to the result adn move
                // j by 1
                
                result.add(b[j]);
                j++;
                
            }else{
                
                // if both has equal element so add any one of them and move
                // both pointers by 1
                
                result.add(a[i]);
                i++;
                j++;
            }
            
        }
        
        
        // Now add remaining element of a[] into result array
        
        while(i<n){
            
            // Skip duplicates elements
            if(i>0 && a[i-1]==a[i]){
                i++;
                continue;
            }
            result.add(a[i]);
            i++;
        }
        
        // Similarily add remaining element of b[] into result array
        while(j<m){
            
            // Skip duplicates elements
            if(j>0 && b[j-1]==b[j]){
                j++;
                continue;
            }
            result.add(b[j]);
            j++;
            
        }
        
        // Return the resulted array
        return result;
        
    }
}







