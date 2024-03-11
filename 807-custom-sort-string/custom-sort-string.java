class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch: s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder ans = new StringBuilder("");
        for(char ch: order.toCharArray())
        {
            if(!map.containsKey(ch)) continue;
            int count = map.get(ch);
            for(int i = 0; i < count; i++)
            {
                ans.append(ch);
            }
            map.remove(ch);
        }
        for(Map.Entry<Character,Integer> entry: map.entrySet())
        {
            int count  = entry.getValue();
            char ch = entry.getKey();
            for(int i = 0 ; i < count; i++)
            {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}