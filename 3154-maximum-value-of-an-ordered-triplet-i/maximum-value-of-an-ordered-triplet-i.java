class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        leftMax[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];

        for(int i = 1; i < n - 1; i++){
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
            rightMax[n - i - 1] = Math.max(rightMax[n - i], nums[n - i]);
        }
        long ans = 0;
        for(int j = 0; j < n; j++){
            long calculate = leftMax[j] - nums[j];
            long multiply = calculate * rightMax[j];
            ans = Math.max(ans, multiply);
        }
        return ans;
    }
}