//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends

/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        Node r1=reverseNode(num1);
        Node r2=reverseNode(num2);
        
        int carry=0;
        Node ans=null;
        Node temp=null;
        while(r1!=null || r2!=null || carry!=0){
            int sum=carry;
            if(r1!=null){
                sum+=r1.data;
                r1=r1.next;
            }
            if(r2!=null){
                sum+=r2.data;
                r2=r2.next;
            }
            int digit=sum%10;
                carry=sum/10;
            Node newNode = new Node(digit);
            if(ans==null){
                ans=temp=newNode;
            }else{
                temp.next=newNode;
                temp=newNode;
            }
        }
        
        ans = reverseNode(ans);
        while(ans!=null && ans.data==0){
            ans=ans.next;
        }
        
        return ans;
    }
    
    static Node reverseNode(Node head){
        Node prev=null;
        Node cur=head;
        while(cur!=null){
            Node next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}













//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends