class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: words[0].toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(Map.Entry<Character,Integer> e: map.entrySet()){
            boolean isValid = true;
            int min = e.getValue();
            for(int i = 1; i < n; i++){
                int m[] = new int[26];
                for(char c: words[i].toCharArray())
                {
                    m[c-'a']++;
                }
                if(m[e.getKey()- 'a'] != 0){
                    min = Math.min(min, m[e.getKey() - 'a']);
                    continue;
                }else{
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                for(int i = 0; i < min; i++){
                    ans.add(e.getKey()+"");
                }
            }
        }
        return ans;
    }
}