//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

// import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}


// } Driver Code Ends

// User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;
// }

class Solution {
    
    static void distanceKDown(Node root,int k, List<Integer> ans){
        if(root==null || k<0) return;
        if(k==0){
        ans.add(root.data);
        return; 
        }
        distanceKDown(root.left,k-1,ans);
        distanceKDown(root.right,k-1,ans);
  }
    
    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        // return the sorted list of all nodes at k dist
        ArrayList<Integer> ans = new ArrayList<>();
        distanceKFromTarget(root,target,k,ans);
        Collections.sort(ans);
        return ans; 
    }
    
     static int distanceKFromTarget(Node root,int target,int k,List<Integer> ans){
    if(root==null) return -1;

    if(root.data==target){
      distanceKDown(root,k,ans);
      return 0;
    }
    int dl =distanceKFromTarget(root.left,target,k,ans);
    if(dl!=-1){
      if(dl+1==k){
        ans.add(root.data);
      }else{
      distanceKDown(root.right,k-dl-2,ans);
      }
      return dl+1;
    }
    int dr = distanceKFromTarget(root.right,target,k,ans);
    if(dr!=-1){
      if(dr+1==k){
        ans.add(root.data);
      }else{
      distanceKDown(root.left,k-dr-2,ans);
      }
      return dr+1;
    }
    return -1;
  }
    
};















//{ Driver Code Starts.
class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root, target, k);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends