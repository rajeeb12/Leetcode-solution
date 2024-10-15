class Solution {
    public long minimumSteps(String s) {
        long ans = 0;
        int countOnes = 0;
        for(char c: s.toCharArray()){
            if(c == '1'){
                countOnes++;
            }else{
                if(countOnes != 0){
                    ans += countOnes;
                }
            }
        }
        return ans;
    }
}