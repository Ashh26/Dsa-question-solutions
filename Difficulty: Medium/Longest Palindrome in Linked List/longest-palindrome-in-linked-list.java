//{ Driver Code Starts
import java.io.*;
import java.lang.Math;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class PalindromeLL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().trim().split("\\s+");
            Node head = new Node(Integer.parseInt(input[0]));
            Node tail = head;
            for (int i = 1; i < input.length; i++) {
                tail.next = new Node(Integer.parseInt(input[i]));
                tail = tail.next;
            }
            Solution ob = new Solution();
            System.out.println(ob.maxPalindrome(head));
        
System.out.println("~");
}
    }

    public static Node insert(Node head, int val) {
        if (head == null) return new Node(val);
        head.next = insert(head.next, val);
        return head;
    }

    /*public static void print(Node head){
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }
    }*/
}
// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}*/
class Solution {
    public static int maxPalindrome(Node head) {
        // add code here.
        if(head==null) return 0;
        if(head.next==null) return 1;
        Node cur=head;
        Node prev=null;
        int ans=0;
        while(cur!=null){
          Node next=cur.next;
          cur.next=prev;
          int commonifcurisexactcenter=countCommon(prev,next);
          int lengthfromexactcenter=2*commonifcurisexactcenter+1;
          int commonifcurisnotexactcenter=countCommon(cur,next);
          int lengthfromnotexactcenter=2*commonifcurisnotexactcenter;
          int largerofthesetwolengths=Math.max(lengthfromexactcenter,lengthfromnotexactcenter);
          ans=Math.max(ans,largerofthesetwolengths);
          prev=cur;
          cur=next;
        }
        return ans;
    }
    
    static int countCommon(Node a,Node b){
      int count=0;
      while(a!=null && b!=null){
        if(a.data==b.data){
          count++;
          a=a.next;
          b=b.next;     
        }else break;
      }
      return count;
    }
    
}





