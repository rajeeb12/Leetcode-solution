class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        for(int i = 0; i < k; i++){
            char c = s.charAt(i);
            if(isVowel(c)) count++;
        }
        int max = count;
        for(int i = k; i < s.length(); i++){
            char c = s.charAt(i);
            count += (isVowel(c) ? 1 : 0);
            count -= (isVowel(s.charAt(i - k))? 1 : 0);
            max = Math.max(max, count);
        }
        return max;
    }
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}