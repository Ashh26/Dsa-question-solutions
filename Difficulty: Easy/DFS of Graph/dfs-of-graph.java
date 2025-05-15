//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                String[] input = br.readLine().trim().split(" ");
                ArrayList<Integer> node = new ArrayList<>();
                for (String s : input) {
                    if (!s.isEmpty()) {
                        node.add(Integer.parseInt(s));
                    }
                }
                adj.add(node);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfs(adj);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
       // List to store the DFS traversal
        ArrayList<Integer> dfsResult = new ArrayList<>();
        
        // Get the number of vertices in the graph
        int V = adj.size();
        
        // Array to mark visited nodes
        boolean[] visited = new boolean[V];
        
        // Start DFS from node 0 (or any other node)
        dfsHelper(0, visited, adj, dfsResult);

        // Return the DFS traversal result
        return dfsResult;
    }

    // Helper method to perform recursive DFS
    private void dfsHelper(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsResult) {
        // Mark the current node as visited
        visited[node] = true;

        // Add the current node to the result list
        dfsResult.add(node);

        // Visit all unvisited adjacent nodes (neighbors)
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited, adj, dfsResult); // Recur for the unvisited neighbor
            }
        }
        
    }
}