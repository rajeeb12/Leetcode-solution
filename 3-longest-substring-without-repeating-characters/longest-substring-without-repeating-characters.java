class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0;
        int res = 0;
        for(int j = 0 ; j < n; j++)
        {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.get(ch) > 1)
            {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1); 
                if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                i++;
            }
            res = Math.max(res, (j - i + 1));
        }
        return res;
    }
}