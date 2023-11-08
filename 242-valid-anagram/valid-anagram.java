class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char str: s.toCharArray()){
            map.put(str, map.getOrDefault(str,0) + 1);
        }
        for(char str: t.toCharArray()){
            if(map.containsKey(str)){
                map.put(str, map.get(str) - 1);
            }else{
                map.put(str, 1);
            }
        }
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue() > 0){
                return false;
            }
        }
        return true;
    }
}