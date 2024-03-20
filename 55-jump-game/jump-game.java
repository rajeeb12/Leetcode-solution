class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int furJump = 0;

        for(int i = 0 ; i <= furJump && i < n; i++)
        {
            furJump = Math.max(furJump, i + nums[i]);
        }
        return (furJump >= n - 1);
    }
}