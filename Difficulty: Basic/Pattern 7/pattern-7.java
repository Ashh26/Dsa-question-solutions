class Solution {

    void printTriangle(int n) {
        // code here
       for(int i=1;i<=n;i++){
           // for Space
           for(int j=1;j<=n-i;j++){
               System.out.print(" ");
           }
           
           // for printing stars
           for(int j=1;j<=2*i-1;j++){
               System.out.print("*");
           }
           
           // for new line
           System.out.println();
           
       }
    }
}