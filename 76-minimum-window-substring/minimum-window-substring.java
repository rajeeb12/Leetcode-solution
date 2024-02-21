class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch: t.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int start = -1 , end = -1, minLength = (int)1e9, count =map.size(),i = 0;

        for(int j = 0 ; j < s.length(); j++)
        {
            char ch = s.charAt(j);
            if(!map.containsKey(ch)) continue;
            
            map.put(ch, map.get(ch) - 1);
            int freq = map.get(ch);
            if(freq == 0)
            {
                count--;
            }
            for(i = i ; count == 0 && i <= j; i++)
            {
                int curLength = j - i + 1;
                if(minLength > curLength)
                {
                    start = i;
                    end = j;
                    minLength = curLength;
                }
                char ch1 = s.charAt(i);
                if(map.containsKey(ch1))
                {
                    map.put(ch1, map.get(ch1) + 1);

                    int freq2= map.get(ch1);
                    if(freq2 > 0)
                    {
                        count++;
                    }
                }
            }
        }
        return (start == -1 || end == -1 ? "": s.substring(start, end + 1));
    }
}