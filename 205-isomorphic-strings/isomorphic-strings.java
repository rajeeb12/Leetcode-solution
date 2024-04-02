class Solution {
    public boolean isIsomorphic(String s, String t) {
       if(s.length() != t.length()) return false;
       HashMap<Character, List<Integer>> map1 = new HashMap<>();
       HashMap<Character, List<Integer>> map2 = new HashMap<>();
       for(int i = 0; i < t.length(); i++)
       {
        char c = s.charAt(i);
        if(!map1.containsKey(c))
        {
            map1.put(c, new ArrayList<>());
        }
        char d = t.charAt(i);
        if(!map2.containsKey(d))
        {
            map2.put(d, new ArrayList<>());
        }
        map1.get(c).add(d -'a');
        map2.get(d).add(c - 'a');
       }
       for(Map.Entry<Character,List<Integer>> it: map1.entrySet())
       {
        List<Integer> ls = it.getValue();
        for(int i = 0; i < ls.size() - 1; i++)
        {
            if(ls.get(i) != ls.get(i + 1)) return false;
        }
       }
       for(Map.Entry<Character,List<Integer>> it: map2.entrySet())
       {
        List<Integer> ls = it.getValue();
        for(int i = 0; i < ls.size() - 1; i++)
        {
            if(ls.get(i) != ls.get(i + 1)) return false;
        }
       }
       return true;

    }
}