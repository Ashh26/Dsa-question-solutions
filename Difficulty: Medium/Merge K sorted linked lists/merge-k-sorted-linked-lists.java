//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    /* Function to print nodes in a given linked list */
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Driver program to test the above functions
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Node> lists = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");
                Node head = null, temp = null;

                for (String value : values) {
                    Node newNode = new Node(Integer.parseInt(value));
                    if (head == null) {
                        head = newNode;
                        temp = head;
                    } else {
                        temp.next = newNode;
                        temp = temp.next;
                    }
                }

                lists.add(head);
            }

            Solution sol = new Solution();
            Node head = sol.mergeKLists(lists);

            printList(head);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java
// class Node
// {
//     int data;
//     Node next;

//     Node(int x)
//     {
//         data = x;
//         next = null;
//     }
// }


// arr is an array of Nodes of the heads of linked lists

class Solution {
    // function for merge only 2 lists
    static Node mergeTwo(Node head1,Node head2){
        Node dummy = new Node(-1);
        Node curr = dummy;
        
        // iterate through both linked lists
        while(head1!=null && head2!=null){
            // add the smaller note to the merged list
            if(head1.data<=head2.data){
                curr.next=head1;
                head1=head1.next;
            }else{
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        
        // if any list is left, append it to the merged list
        if(head1!=null){
            curr.next=head1;
        }else{
            curr.next = head2;
        }
        
        // return the merged list starting form the next of the dummy node
        return dummy.next;
    }
    
    
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // initialize result as empty
       Node result = null;
       
       // one by one merge all lists with result and keep updating result
       for(Node node:arr){
           result = mergeTwo(result,node);
       }
       return result;
       
    }
    
    static void printList(Node node){
        while(node!=null){
            System.out.println(node.data+" ");
            node = node.next;
        }
    }
}





