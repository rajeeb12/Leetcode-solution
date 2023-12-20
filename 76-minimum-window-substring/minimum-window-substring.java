class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0 ;

        for(char ch: t.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0 )  + 1);
        }
        int count = map.size();
        int start = -1 , end = -1, size = (int)1e9;

        for(int right = 0 ; right < s.length(); right++)
        {
            char ch = s.charAt(right);
            if(!map.containsKey(ch)) continue;

            map.put(ch, map.get(ch) - 1);
            int frequency = map.get(ch);

            if(frequency == 0) count--;

            for(left = left ; count == 0 && left <= right ; left++)
            {
               int currSize = right - left + 1;
               if(currSize < size)
               {
                   size = currSize;
                   start = left;
                   end = right;
               }
               char leftCh = s.charAt(left);
               if(map.containsKey(leftCh))
               {
                    map.put(leftCh, map.get(leftCh) + 1);
                    int freq = map.get(leftCh);
                    if(freq > 0)
                    {
                        count++;
                    }
               }
            }
        }
        return ((start == -1 || end == -1) ? "" : s.substring(start , end + 1));
    }
}