class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0, ans = 0;
        for(int j = 0; j < n; j++){
            while(i <= j && nums[j] - nums[i] > 1){
                i++;
            }
            if(nums[j] - nums[i] == 1){
                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}