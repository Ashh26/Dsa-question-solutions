//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().heapSort(arr);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            // System.out.println();

            System.out.println();

            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[]) {
        // code here
        
        int len = arr.length;
        
        for(int i=(len/2)-1; i>=0;i--)  // start from parent node indexe position
        {
            heapify(arr,len,i);        // call the heapfy method to sort the array
            // heapfy is the process of converting binary tree into heap data structure
        }  
        
        
         // after sort the largest value is in the first position not swap with
            // last index position
        for(int i=len-1;i>=0;i--){
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                
                // now after the first largest element is swap to last index postion
                // we again call the heapify method for another round until you get 
                // array fully sorted
                heapify(arr,i,0);
                
            }
        
    }
    
     public void heapify(int[] arr,int n,int i){
            
            int largest = i;     // parent node index position
            
            int li = 2*i+1;     // left child node index position
            
            int ri = 2*i+2;    // right child node index position
            
            
            
            // if left childe node index postion is less then array of length and
            // value of left side child not is bigger than parent node value than 
            // change the index position of largest. by initialize with li
            
            if(li<n && arr[li]>arr[largest]){
                largest = li;
            }
            
            // if right childe node index postion is less then array of length and
            // value of right side child not is bigger than parent node value than 
            // change the index position of largest. by initialize with ri
            
            if(ri<n && arr[ri]>arr[largest]){
                largest = ri;
            }
            
            
            // check if largest is not equal to  i  than change the value of parent node
            // and call heapify again
            
            if(largest!=i){
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                
                heapify(arr,n,largest);
                
            }
            
        }
    
}








