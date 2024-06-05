class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        int[] map = new int[26];

        for(char c: words[0].toCharArray()){
            map[c-'a']++;
        }
        
        for(int alphabet = 0; alphabet < 26; alphabet++){
            if(map[alphabet] == 0) continue;

            boolean isValid = true;
            int min = map[alphabet];
            for(int i = 1; i < n; i++){
                int m[] = new int[26];
                for(char c: words[i].toCharArray())
                {
                    m[c-'a']++;
                }
                if(m[alphabet] != 0){
                    min = Math.min(min, m[alphabet]);
                    continue;
                }else{
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                for(int i = 0; i < min; i++){
                    ans.add((char)(alphabet + 'a')+"");
                }
            }
        }
        return ans;
    }
}