class Solution {
    public int maxVowels(String s, int k) {
        int map[] = new int[26];
        int count = 0;
        for(int i = 0; i < k; i++){
            map[s.charAt(i) -'a']++;
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        int max = count;
        int i = 0;
        for(int j = k; j < s.length(); j++){
            map[s.charAt(i) -'a']--;
            map[s.charAt(j) -'a']++;
            if(isVowel(s.charAt(i))){
                count--;
            }
            if(isVowel(s.charAt(j))){
                count++;
            }
            max = Math.max(count, max);
            i++;
        }
        return max;
    }
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o'|| c =='u') return true;
        return false;
    }
}