class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        int n = s.length();
        while(right < n)
        {
            map.put(s.charAt(right) , map.getOrDefault(s.charAt(right), 0) + 1);
            int mostFrequentChar = 0;

            for(int i: map.values())
            {
                mostFrequentChar = Math.max(mostFrequentChar, i);
            }
            int window = right - left + 1;
            while(window - mostFrequentChar > k && left < right)
            {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                for(int i: map.values())
                {
                    mostFrequentChar = Math.max(mostFrequentChar, i);
                }
                left++;
                window = right - left + 1;
            } 
            max = Math.max(max, window);
            right++;
        }
        return max;
    }
}