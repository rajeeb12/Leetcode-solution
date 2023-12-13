class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int n = s.length();
        int l = 0, r = 0, i = 0;
        reverse(0,n-1, str);
        while(i < n)
        {
            while(i < n &&  str[i] != ' ')
            {
                str[r++] = str[i++];
            }

            if(l < r && r < n)
            {
                reverse(l,r-1,str);
                str[r] = ' ';
                r++;

                l = r;
            }
            i++;
        }
        reverse(l, r-1,str);
        String res = new String(str);

        return res.substring(0 ,res.charAt(r - 1) == ' ' ? r - 1 : r);
    }
    public void reverse(int i ,int j,char[] str)
    {
        while(i < j)
        {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
}