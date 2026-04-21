class Solution {
    public int longestSubarray(int[] nums) {
        int countOne = 0, countZero = 0;
        int i = 0, max = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] == 1) countOne++;
            else countZero++;
            while(countZero > 1){
                if(nums[i] == 1) countOne--;
                else countZero--;
                i++;
            }
            max = Math.max(max, countOne);
        }
        if(max == nums.length) return max - 1;
        return max;
    }
}