//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfsResult = new ArrayList<>();
        
        // Get the number of vertices in the graph
        int V = adj.size();
        
        // Array to mark visited nodes
        boolean[] visited = new boolean[V];
        
        // Initialize a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        
        // Start BFS from node 0 (or any node, assuming the graph is connected)
        visited[0] = true;
        queue.add(0); // Add the starting node to the queue
        
        while (!queue.isEmpty()) {
            // Dequeue a node and add it to the result
            int node = queue.poll();
            bfsResult.add(node);
            
            // Explore all adjacent nodes of the current node
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    // If the neighbor hasn't been visited, mark it and enqueue it
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        // Return the BFS traversal result
        return bfsResult;
        
    }
}


//{ Driver Code Starts.

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
            ArrayList<Integer> ans = obj.bfs(adj);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends