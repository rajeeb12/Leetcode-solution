class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int countA = 0, countB = 0;
        for(char c: s.toCharArray()){
            if(c == 'a') countA++;
        }
        int result = (int)1e9;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a') countA--;
            result = Math.min(result, countA + countB);
            if(s.charAt(i) == 'b') countB++;
        }
        return result;
    }
}