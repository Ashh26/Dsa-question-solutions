//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            int x = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            Node res = ob.partition(head, x);
            printList(res);
            System.out.println();
        
System.out.println("~");
}
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node node, int x) {
        // Your code here
        if(node==null || node.next==null) return node;
        
        Node shead=new Node(-1);
        Node mhead=new Node(-1);
        Node lhead=new Node(-1);
        
        Node stail=shead;
        Node mtail=mhead;
        Node ltail=lhead;
        Node cur=node;
        
        while(cur!=null){
            if(cur.data<x){
                stail.next=cur;
                stail=cur;
            }else if(cur.data==x){
                mtail.next=cur;
                mtail=cur;
            }else{
                ltail.next=cur;
                ltail=cur;
            }
            cur=cur.next;
        }
        stail.next=mhead.next;
        mtail.next=lhead.next;
        ltail.next=null;
        return shead.next;
    }
}




