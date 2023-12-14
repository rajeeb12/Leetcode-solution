class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int count = 0;
        int left = 0, right = 0;
        int size = s.length();
        while(right < k)
        {
            if(check(s.charAt(right)))
            {
                count++;
            }
            right++;
        }
        max = Math.max(max, count);
        while(right < size)
        {
            if(check(s.charAt(left)))
            {
                count--;
            }
            if(check(s.charAt(right)))
            {
                count++;
            }
            max = Math.max(max, count);
            left++;
            right++;
        }
        return max;
    }
    public boolean check(char c)
    {
        if(c == 'a' || c == 'e' || c == 'i' || c=='o' || c=='u') return true;

        return false;
    }
}