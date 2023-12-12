class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n < 2) return 0;
        return ((nums[n - 1] - 1) * (nums[n-2] -1));
    }
}