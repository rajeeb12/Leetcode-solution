class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char ch: ransomNote.toCharArray())
        {
            map1.put(ch, map1.getOrDefault(ch, 0 ) + 1);
        }
        for(char ch: magazine.toCharArray())
        {
            map2.put(ch, map2.getOrDefault(ch, 0 ) + 1);
        }
        for(Map.Entry<Character, Integer> entry: map1.entrySet())
        {
            char key = entry.getKey();
            int value = entry.getValue();
            if(!map2.containsKey(key)) return false;

            int value2 = map2.get(key);
            if(value2 < value) return false;
        }
        return true;
    }
}