class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] % 2;
        }
        return solve(nums, k) - solve(nums, k - 1);
    }
    public int solve(int nums[],int k){
        int sum = 0;
        int i = 0;
        int ans = 0;
        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            while(sum > k && i <=j){
                sum -= nums[i];
                i++;
            }
            ans += (j - i + 1);
        }
        return ans;
    }
}