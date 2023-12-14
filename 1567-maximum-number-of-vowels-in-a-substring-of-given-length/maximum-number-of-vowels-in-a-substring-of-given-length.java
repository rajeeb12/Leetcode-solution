class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int count = 0;
        int left = 0, right = 0;
        int size = s.length();
        for(int i = 0 ; i < size; i++)
        {
            if(check(s.charAt(i)))
            {
                count++;
            }
            if(i >= k)
            {
                if(check(s.charAt( i - k)))
                {
                    count--;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
    public boolean check(char c)
    {
        if(c == 'a' || c == 'e' || c == 'i' || c=='o' || c=='u') return true;

        return false;
    }
}