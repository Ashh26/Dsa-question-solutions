//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);

            if (ans.size() == 0) {
                System.out.println("[]");
            } else {
                for (int i : ans) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
       int n = nums.length;
       
       int ele1 = -1,ele2=-1;
       int count1 = 0,count2 = 0;
       
       for(int i=0;i<n;i++){
           if(ele1==nums[i]){
               count1++;
           }else if(ele2==nums[i]){
               count2++;
           }else if(count1==0){
               ele1 = nums[i];
               count1++;
           }else if(count2==0){
               ele2 = nums[i];
               count2++;
           }else{
               count1--;
               count2--;
           }
           
       }
       
             
           
            List<Integer> result = new ArrayList<>();
                count1=0;
                count2=0;
                
            for(int i=0;i<n;i++){
               if(ele1==nums[i]){
                   count1++;
               }
               
               if(ele2==nums[i]){
                   count2++;
               }
           }
           
           if(count1>n/3){
               result.add(ele1);
           }
           
           if(count2>n/3 && ele1!=ele2){
               result.add(ele2);
           }
           
           if(result.size()==2 && result.get(0)>result.get(1)){
               int temp = result.get(0);
                   result.set(0,result.get(1));
                   result.set(1,temp); 
           }
           
           return result;
       
       
    }
}














