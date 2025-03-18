class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        for(int i = 0; i < n; i++){
            int mask = 0;
            for(int j = i; j < n; j++){
                if((nums[j] & mask) != 0) break;

                mask |= nums[j];
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }
}