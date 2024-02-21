class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int index = n - 1;

        for(int i = n - 2 ; i >= 0; i--)
        {
            int temp = nums[i] + i;
            if(temp >= index)
            {
                index = i;
            }
        }
        return (index == 0);
    }
}