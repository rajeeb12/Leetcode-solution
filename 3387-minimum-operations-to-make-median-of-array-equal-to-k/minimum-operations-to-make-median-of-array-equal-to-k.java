class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        long ans = 0;
        Arrays.sort(nums);

        int n = nums.length;
        int median = nums[n / 2];
        if(k == median) return 0;

        ans += Math.abs(k - nums[n / 2]);
        int index = (n / 2) - 1;

        while(index >= 0 && nums[index] > k)
        {
            ans += Math.abs(k - nums[index]);
            index--;
        }
        index = (n / 2) + 1;

        while(index < n && nums[index] < k){
            ans += Math.abs(k - nums[index]);
            index++;
        }
        return ans;
    }
}