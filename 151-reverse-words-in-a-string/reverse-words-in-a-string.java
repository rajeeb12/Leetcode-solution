class Solution {
    public String reverseWords(String s) {
        if(s.length() ==0) return "";
        StringBuilder str = new StringBuilder(); 
        for(int i = 0 ; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch != ' ')
            {
                str.append(ch);
            }else if(i > 0 && s.charAt(i - 1) != ' ')
            {
                str.append(' ');
            }
        }
        if(str.length() == 0) return "";
        String temp = str.toString();
        String arr[] = temp.split(" ");
        String ans = "";
        for(int i = arr.length - 1; i >= 0; i--)
        {
            ans += arr[i] +" ";
        }
        return ans.substring(0, ans.length() - 1);
    }
}