//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {

        // sort the array based on start values
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        
        // index of last merged
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{arr[0][0],arr[0][1]});
        
        for(int i=1;i<arr.length;i++){
            // if current interval overlaps with the last merged interval
            int[] last = result.get(result.size()-1);
            int[] curr = arr[i];
            
            if(curr[0]<=last[1]){
                last[1] = Math.max(last[1],curr[1]);
            }else{
                result.add(new int[]{curr[0],curr[1]});
            }
            
        }
        
        // retunr size of the merged intervals
        return result;

    }
}