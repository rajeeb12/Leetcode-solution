class Solution {
    public int possibleStringCount(String word) {
        int ans = 1;
        char prev = word.charAt(0);
        int count = 1;
        for(int i = 1; i < word.length(); i++){
            if(word.charAt(i) == prev){
                count++;
            }else{
                prev = word.charAt(i);
                ans += (count > 1 ? count - 1: 0);
                count = 1;
            }
        }
        ans += (count > 1 ? count - 1 : 0);
        return ans;
    }
}