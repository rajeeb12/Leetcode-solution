class Solution {
    public int jump(int[] nums) {
        int countJump = 0;
        int n = nums.length;
        int furJump = 0, curEnd = 0;
        if(nums[0] == 0 || n == 1) return 0;
        
        for(int i = 0; i < n - 1; i++)
        {
            furJump = Math.max(furJump, i + nums[i]);
            if(i == curEnd)
            {
                countJump++;
                curEnd = furJump;
            }
        }
        return countJump;
    }
}