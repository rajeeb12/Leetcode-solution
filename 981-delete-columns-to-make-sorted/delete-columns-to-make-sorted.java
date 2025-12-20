class Solution {
    public int minDeletionSize(String[] strs) {
        int ans = 0;
        for(int i = 0; i < strs[0].length(); i++){
            int minAscii = -1;
            for(int j = 0; j < strs.length; j++){
                int asciiValue = strs[j].charAt(i) - 'a';
                if(minAscii == -1){
                    minAscii = asciiValue;
                    continue;
                } 
                if(asciiValue >= minAscii){
                    minAscii = asciiValue;
                }else{
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}