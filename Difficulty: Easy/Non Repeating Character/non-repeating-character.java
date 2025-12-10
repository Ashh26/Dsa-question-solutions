class Solution {
    public char nonRepeatingChar(String s) {
        // code here
        
        int MAX_CHAR = 26;
        int arr[] = new int[MAX_CHAR];
        Arrays.fill(arr,-1);
        
        for(int i=0;i<s.length();i++){
            int index = s.charAt(i)-'a';
            if(arr[index]==-1){
                arr[index]=i;
            }else{
                arr[index] = -2;
            }
        }
        
        int idx=-1;
        
        for(int i=0;i<MAX_CHAR;i++){
            if(arr[i]>=0 && (idx==-1 || arr[i]<arr[idx])){
                idx=i;
            }
        }
        
        return (idx==-1) ? '$' : s.charAt(arr[idx]);
        
    }
}
