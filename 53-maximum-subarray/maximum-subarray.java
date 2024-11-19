class Solution {
    public int maxSubArray(int[] nums) {
        int csum = 0;
        int max = -(int)1e9; 
        for(int i : nums){
            if(csum < 0) csum = 0;

            csum += i;
            max = Math.max(max, csum);
        }
        return max;
    }
}