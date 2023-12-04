class Solution {
    public int removeDuplicates(int[] nums) {
        int p1 = 0;
        for(int i = 1 ; i < nums.length; i++)
        {
            if(nums[i] == nums[i-1]) continue;
            nums[++p1] = nums[i];
        }
        return p1 + 1 ;
    }
}