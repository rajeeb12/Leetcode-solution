class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        for(int i : nums) rightSum += i;

        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(leftSum == rightSum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}