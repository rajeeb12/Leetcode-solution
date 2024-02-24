class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 1; i > 0; i--)
        {
            if(nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}