class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = 1;
        int ans[]= new int[n];
        Arrays.fill(ans, 1);
        for(int i = 0 ; i < n ; i++)
        {
            ans[i] = ans[i] * left;
            left = left * nums[i];
            int j = n - i - 1;
            ans[j] = ans[j] * right;
            right = right * nums[j];
        }
        return ans;
    }
}