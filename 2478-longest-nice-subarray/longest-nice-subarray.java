class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 0, mask = 0, i = 0;
        for(int j = 0; j < n; j++){
            while((mask & nums[j]) != 0){
                mask ^= nums[i++];
            }
            mask |= nums[j];
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}