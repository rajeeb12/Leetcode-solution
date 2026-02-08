class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int countB = 0, result = 0;

        for(char c: s.toCharArray()){
            if(c == 'b'){
                countB++;
            }else if(countB != 0){
                result++;
                countB--;
            }
        }
        return result;
    }
}