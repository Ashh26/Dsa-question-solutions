//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution obj = new Solution();
            Node res = obj.Bst(arr, n);
            printPostorder(res);
            System.out.println();
        
System.out.println("~");
}
    }

    
// } Driver Code Ends

// User function Template for Java

/*
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

static class Solution {
    // Function that constructs BST from its preorder traversal.
    private int index = 0;
    public Node Bst(int pre[], int size) {
        return build(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private Node build(int[] preorder, int lower, int upper) {
        if (index >= preorder.length) return null;

        int val = preorder[index];
        if (val < lower || val > upper) return null;

        index++;
        Node root = new Node(val);
        root.left = build(preorder, lower, val);
        root.right = build(preorder, val, upper);
        return root;
        
    }
}


//{ Driver Code Starts.

    public static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}
// } Driver Code Ends