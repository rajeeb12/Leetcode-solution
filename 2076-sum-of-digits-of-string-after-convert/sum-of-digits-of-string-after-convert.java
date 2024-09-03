class Solution {
    public int getLucky(String s, int k) {
        if(s.length() == 0) return 0;
        String a ="";

        for(char c: s.toCharArray()){
            a += ((int)c - (int)'a' + 1) +"";
        }
       
        while(k-- > 0 && a.length() > 1)
        {
            String temp = a;
            long temp2 = 0;

            for(char c: a.toCharArray()){
                temp2 += c -'0';
            }
            a = temp2+"";
        }
        return Integer.parseInt(a);
    }
}