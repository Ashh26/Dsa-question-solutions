class Geeks {

    static void checkString(String s) {
        int v = 0;
        int c = 0;

        // Your code here
        s = s.toLowerCase();
        for(char ch:s.toCharArray()){
            if(ch>='a' && ch<='z'){
                if("aeiou".indexOf(ch)!=-1){
                    v++;
                }else{
                    c++;
                }
            }
        }

        if (v > c)
            System.out.print("Yes");
        else if (c > v)
            System.out.print("No");
        else
            System.out.print("Same");

        System.out.println();
    }
}

//Position this line where user code will be pasted.