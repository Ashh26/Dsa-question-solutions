//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        Scanner sc=new Scanner(System.in);
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String P[]=br.readLine().trim().split(" ");
            int m=Integer.parseInt(P[0])-1;
            int n=Integer.parseInt(P[1])-1;
            String A[]=br.readLine().trim().split(" ");
            String B[]=br.readLine().trim().split(" ");
            ArrayList<Integer> l=new ArrayList<>();
            for(String s : A){
                if(s.equals(""))
                continue;
                l.add(Integer.parseInt(s));
            }
            for(String s : B){
                if(s.equals(""))
                continue;
                l.add(Integer.parseInt(s));
            }
            int [] X =new int[m];
            int [] Y=new int[n];
            int ind=0;
            for(int i=0;i<m;i++){
                X[i]=l.get(ind++);
            }
            for(int i=0;i<n;i++){
                Y[i]=l.get(ind++);
            }
            
            Solution obj = new Solution();
            int res = obj.minimumCostOfBreaking(X, Y,m,n);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumCostOfBreaking(int[] X, int[] Y, int M, int N) {
        // code here
         Arrays.sort(X);
        Arrays.sort(Y); 

        // Pieces in each direction
        int hCount = 1, vCount = 1; 
        int i = X.length - 1, j = Y.length - 1; 
        int totalCost = 0;

        // Process the cuts in greedy manner
        while (i >= 0 && j >= 0) {
            
            // Choose the larger cost cut to 
            // minimize future costs
            if (X[i] >= Y[j]) {
                totalCost += X[i] * hCount; 
                vCount++;
                i--;
            } 
            else {
                totalCost += Y[j] * vCount; 
                hCount++;
                j--;
            }
        }

        // Process remaining vertical cuts
        while (i >= 0) {
            totalCost += X[i] * hCount;
            vCount++;
            i--;
        }

        // Process remaining horizontal cuts
        while (j >= 0) {
            totalCost += Y[j] * vCount;
            hCount++;
            j--;
        }

        return totalCost;
    }
}
