//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.getComponents(V, edges);
            for (List<Integer> component : res) {
                Collections.sort(component);
            }
            res.sort((a, b) -> {
                int minLen = Math.min(a.size(), b.size());
                for (int i = 0; i < minLen; i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return a.size() - b.size(); // shorter one comes first if same prefix
            });

            for (List<Integer> component : res) {
                for (int node : component) {
                    System.out.print(node + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
          // Create an adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the adjacency list (undirected graph)
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Array to track visited nodes
        boolean[] visited = new boolean[V];

        // List to store the connected components
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();

        // Iterate over all nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // If the node is not visited, start a new DFS to find a component
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, visited, adj, component); // Call DFS to fill the component
                components.add(component);
            }
        }

        // Return the list of connected components
        return components;
    }

    // Helper method to perform DFS traversal
    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> component) {
        // Mark the node as visited
        visited[node] = true;
        component.add(node); // Add node to the current component

        // Visit all unvisited neighbors
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, component); // Recursively visit neighbors
            }
        }
    }
}