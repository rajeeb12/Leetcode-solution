class Solution {
    public int characterReplacement(String s, int k) {
        int map[]= new int[26];
        int left = 0;
        int right = 0;
        int max = 0;
        int n = s.length();
        int mostFrequentChar = 0;
        while(right < n)
        {
            map[s.charAt(right)-'A']++;
            mostFrequentChar = Math.max(mostFrequentChar, map[s.charAt(right) - 'A']);
            
            int window = right - left + 1;
            if((window - mostFrequentChar) <= k)
            {
                max = Math.max(max, window);
            }else{
                mostFrequentChar = 0;
                map[s.charAt(left)-'A']--;
                left++;
            }
            right++;
        }
        return max;
    }
}