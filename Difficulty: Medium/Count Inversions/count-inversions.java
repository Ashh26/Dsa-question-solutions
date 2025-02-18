//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    
        static int merge(int[] arr,int[] temp,int st,int mid,int end){
          
            int i=st;
            int j=mid+1;
            int k=st;
            int invCount=0;
            
            while(i<=mid && j<=end){
                if(arr[i]<=arr[j]){
                    temp[k++]=arr[i++];
                }else{
                    temp[k++]=arr[j++];
                    invCount = invCount+(mid-i+1);
                }
            }
            while(i<=mid){
                temp[k++]=arr[i++];
            }
            
            while(j<=end){
                temp[k++]=arr[j++];
            }
            
            for(int x=st;x<=end;x++){
                arr[x]=temp[x];
            }
            return invCount;
        }
    

       static int divideArray(int[] arr,int[] temp,int st,int end)
       {
           if(st>=end) return 0;
           int mid = (st+end)/2;
           
           return divideArray(arr,temp,st,mid)+divideArray(arr,temp,mid+1,end)
           +merge(arr,temp,st,mid,end);
        }

    static int inversionCount(int arr[]) {
        
        int[] temp = new int[arr.length];
        
        return divideArray(arr,temp,0,arr.length-1);
    }
}






