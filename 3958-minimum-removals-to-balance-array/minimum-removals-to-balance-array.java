class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int maxBalanceLength = 0;
        int i = 0, j = 0, n = nums.length;

        while(j < n){
            while(i < j && (long) nums[j] > (long) nums[i] * k){
                i++;
            }
            maxBalanceLength = Math.max(maxBalanceLength , j - i + 1);
            j++;
        }
        return n - maxBalanceLength; 
    }
}