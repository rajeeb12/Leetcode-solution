class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int max[] = new int[n];
        max[n - 1] = 0;

        for(int i = n - 2; i >= 0; i--){
            max[i] = Math.max(max[i + 1], nums[i + 1]);
        }
        int ans = -1;
        for(int i = 0; i < n; i++){
            if(nums[i] < max[i]){
                ans = Math.max(ans, max[i] - nums[i]);
            }
        }
        return ans;
    }
}