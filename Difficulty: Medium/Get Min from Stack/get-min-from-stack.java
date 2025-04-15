//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    
    int minEle;
    Stack<Integer> stack;
        
    public Solution() {
        stack=new Stack<>();
    }

    // Add an element to the top of Stack
    public void push(int x) {
        // code here
        if(stack.isEmpty()){
            stack.push(0);
            minEle=x;
        }else{
            int diff=x-minEle;
            stack.push(diff);
            if(diff<0){
                minEle=x;
            }
        }
    }

    // Remove the top element from the Stack
    public void pop() {
        // code here
        if(stack.isEmpty()) return;
        int top = stack.pop();
        if(top<0){
            minEle=minEle-top;
        }
    }

    // Returns top element of the Stack
    public int peek() {
        // code here
        if(stack.isEmpty()) return -1;
        int top=stack.peek();
        if(top>0){
            return minEle+top;
        }else{
            return minEle;
        }
    }

    // Finds minimum element of Stack
    public int getMin() {
        // code here
        if(stack.isEmpty()) return -1;
        return minEle;
    }
}





