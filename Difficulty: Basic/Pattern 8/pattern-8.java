class Solution {

    void printTriangle(int n) {
        // code here
        for(int i=1;i<=n;i++){
            // for space
            for(int j=1;j<=i-1;j++){
                System.out.print(" ");
            }
            
            //for stars
            for(int j=1;j<=(2*n-(2*i-1));j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}





//     *
//   * *
//   * * *
//  * * * *
// * * * * *
// for this pattern
//
//
// for(int i=1;i<=n;i++){
//             // for space
//             for(int j=1;j<=n-i;j++){
//                 System.out.print(" ");
//             }
            
//             // for stars
//             for(int j=1;j<=i;j++){
//                 System.out.print("* ");
//             }
//             System.out.println();
            
//         }








