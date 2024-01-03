class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) return s.length();
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int max = 0;
        while(right < n)
        {
            if(!set.contains(s.charAt(right)))
            {
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
            }else{
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }
}