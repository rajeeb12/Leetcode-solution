class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;

        for(int i = 0; i < nums.length; i++){
            int maxRight = i + nums[i];

            if(maxIndex < i) return false;

            maxIndex = Math.max(maxIndex, maxRight);
        }
        return true;
    }
}