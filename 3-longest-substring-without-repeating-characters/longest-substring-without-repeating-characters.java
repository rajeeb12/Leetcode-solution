class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, n = s.length() , ans = 0;

        if(s.length() == 0){
            return 0;
        }

        for(int j = 0; j < n; j++){
            
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while(i < j && map.get(s.charAt(j) ) > 1){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        } 
        return ans;
    }
}