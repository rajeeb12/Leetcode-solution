class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int min = nums[0], ans = -1;

        for(int i = 1; i < n; i++){
            if(min < nums[i]){
                ans = Math.max(ans, nums[i] - min);
            }
            min = Math.min(min, nums[i]);
        }
        return ans;
    }
}