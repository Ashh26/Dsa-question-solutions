//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public int[][] kClosest(int[][] points, int k) {
       // sort the array based on
       // the length of the straight line between two points
       // from the origin
       Arrays.sort(points,(point1,point2)->{
           // calculate the squared distance for the first point of the origin
           int distance1 = point1[0]*point1[0] + point1[1]*point1[1];
           
           // calculate the squared distance for the first point of the origin 
           int distance2 = point2[0]*point2[0] + point2[1]*point2[1];
           
           // compare the two distance
           return distance1-distance2;
       });
       // return the first k element of the sorted array,
       // whiche are the k closest points to the origin
       return Arrays.copyOfRange(points,0,k);
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends