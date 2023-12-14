class Solution {
    public boolean rotateString(String s, String goal) {
        char ch[]= s.toCharArray();
        if(s.equals(goal)) return true;

        for(int i = 0 ; i < s.length() - 1; i++)
        {
            rotate(ch);
            String str = new String(ch);
            if(str.equals(goal)) return true;
        }
        return false;
    }
    public void rotate(char[] ch)
    {
        char ch0= ch[0];
        for(int i = 1; i < ch.length ; i++)
        {
            ch[i-1]= ch[i];
        }
        ch[ch.length -1 ]= ch0;
    }
}