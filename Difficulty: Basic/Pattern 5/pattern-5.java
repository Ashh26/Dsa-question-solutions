class Solution {

    void printTriangle(int n) {
        // code here
       for(int i=1;i<=n;i++){
           for(int j=i;j<=n;j++){
               System.out.print("* ");
           }
           System.out.println();
       }
    }
}