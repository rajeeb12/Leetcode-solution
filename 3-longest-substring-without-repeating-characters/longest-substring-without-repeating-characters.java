class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) return s.length();
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int max = 0;
        while(right < n)
        {
            if(!set.contains(s.charAt(right)))
            {
                set.add(s.charAt(right++));
                max = Math.max(set.size(), max);
            }else{
                set.remove(s.charAt(left++));
            }
        }   
        return max;
    }
}