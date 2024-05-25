class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int count[] = new int[26];
        for(char c: letters){
            count[c-'a']++;
        }
        return solve(0, words,letters,score,count);
    }
    public int solve(int index,String[] words,char[] letters,int[] score,int[] count){
        if(index == words.length) return 0;

        int take = 0, noTake = 0;
        int sum = 0;
        boolean isValid = true;
        for(char c: words[index].toCharArray()){
            if(count[c-'a'] == 0) isValid = false;
            
            sum += score[c-'a'];
            count[c-'a']--;
        }
        if(isValid){
            take = sum + solve(index + 1,words,letters,score,count);
        }
        for(char c: words[index].toCharArray()){
            count[c-'a']++;
        }
        noTake = solve(index + 1, words,letters, score, count);

        return Math.max(noTake, take);
    }
}