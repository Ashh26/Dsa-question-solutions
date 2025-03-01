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

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    int[] array;
    int[] tempArray;
    int length;

    void mergeSort(int arr[], int l, int r) {
        this.array = arr;
        this.length = arr.length;
        this.tempArray = new int[length];
        
        divideArray(array,0,length-1);
    }
    
    public void divideArray(int[] array,int l,int r)
    {
        if(l<r){
            int m = (l+r)/2;
            
            divideArray(array,l,m);
            
            divideArray(array,m+1,r);
            
            mergeArray(l,m,r);
        }
    }
    
    public void mergeArray(int l,int m,int r)
    {
        for(int i=l;i<=r;i++){
            tempArray[i] = array[i];
        }
        
        int i=l;
        int j=m+1;
        int k=l;
        
        while(i<=m && j<=r){
            if(tempArray[i]<=tempArray[j]){
                array[k] = tempArray[i];
                i++;
            }else{
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }
        
        while(i<=m){
            array[k] = tempArray[i];
            k++;
            i++;
        }
        
    }
}









