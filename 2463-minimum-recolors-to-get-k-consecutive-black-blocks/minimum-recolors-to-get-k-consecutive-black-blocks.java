class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int countW = 0, countB = 0;
        for(int i = 0; i < k; i++){
            if(blocks.charAt(i) == 'W') countW++;
        }
        int ans = countW; 
        int i = 0, j = k;

        while(j < n){
            if(blocks.charAt(j) == 'W'){
                countW++;
            }
            if(blocks.charAt(i) == 'W'){
                countW--;
            }
            ans = Math.min(ans, countW);
            i++;
            j++;
        }
        return ans;
    }
}