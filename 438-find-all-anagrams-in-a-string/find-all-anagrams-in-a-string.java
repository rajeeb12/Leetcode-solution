class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) return new ArrayList<>();
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < p.length(); i++)
        {
            char ch = p.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0 ) + 1);
            char ch1 = s.charAt(i);
            map2.put(ch1, map2.getOrDefault(ch1, 0) + 1);
        }
        int i = 0;
        // map1 - p
        // map2 - s
        for(int j = p.length(); j < s.length() ; j++)
        {
            boolean flag = true;
            for(Map.Entry<Character, Integer> entry : map2.entrySet())
            {
                char ch = entry.getKey();
                int value = entry.getValue();
                if(!map1.containsKey(ch) || value != map1.get(ch))
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                ans.add(i);
            }
            map2.put(s.charAt(i), map2.get(s.charAt(i)) - 1);
            if(map2.get(s.charAt(i)) == 0) map2.remove(s.charAt(i));
            i++;
            map2.put(s.charAt(j), map2.getOrDefault(s.charAt(j), 0) + 1);
        }
        boolean flag = true;
        for(Map.Entry<Character, Integer> entry : map2.entrySet())
        {
            char ch = entry.getKey();
            int value = entry.getValue();
            if(!map1.containsKey(ch) || value != map1.get(ch))
            {
                flag = false;
                break;
            }
        }
        if(flag) ans.add(i);
        return ans;
    }
}