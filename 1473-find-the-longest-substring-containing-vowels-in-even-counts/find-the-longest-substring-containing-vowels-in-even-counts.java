class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        String s1 = "aeiou";
        int cur = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int index = s1.indexOf(c);
            if(index != -1)
            {
                cur ^= (1 << index);
            }

            if(map.containsKey(cur))
            {
                max = Math.max(max, i - map.get(cur));
            }else{
                map.put(cur, i);
            }
        }
        return max;
    }
}