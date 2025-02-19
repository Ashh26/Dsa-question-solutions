//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().quickSort(arr, 0, n - 1);
            printArray(arr);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        // store the partitioned value in the variable
        int pi = partition(arr,low,high);
        
        // now check if pi-1 value is bigger then the low index value then recursively call
        if(low<pi-1){
            quickSort(arr,low,pi-1);
        }
        // again check if pi value is smaller then the high index value then recurively call
        if(pi<high){
            quickSort(arr,pi,high);
        }
        
    }

    static int partition(int arr[], int low, int high) {
        // first find pivot element
        int pivot = arr[(low+high)/2];
        
        // now sort the array in the left and right perespective
        while(low<=high){
            // sort the element of the left side of the pivot and then increament
            while(arr[low]<pivot){
                low++;
            }
            //sort the element of the right side of the pivot and then decrement
            while(pivot<arr[high]){
                high--;
            }
            // check if low<=high then swap the elements
            if(low<=high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        // return the index value of the array
        return low;
    }
}







