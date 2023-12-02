class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character,Integer> map= new HashMap<>();
        for(char ch: chars.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        int good = 0;

        for(String str: words)
        {
            HashMap<Character,Integer> map2 = new HashMap<>();
            for(char ch: str.toCharArray())
            {
                map2.put(ch, map2.getOrDefault(ch,0) + 1);
            }
            boolean isGood = true;
            for(Map.Entry<Character,Integer> entry: map2.entrySet())
            {
                char ch = entry.getKey();
                int value = entry.getValue();
                if(!map.containsKey(ch) || !(map.get(ch) >= value))
                {
                    isGood = false;
                    break;
                }
            }
            if(isGood) good += str.length();
        }
        return good;
    }
}