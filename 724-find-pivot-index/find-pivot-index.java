class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        int preSum = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = preSum;
            preSum += nums[i];
        }
        int sufSum = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suffix[i] = sufSum;
            sufSum += nums[i];
        }
        for(int i = 0; i < n; i++){
            if(prefix[i] == suffix[i]) return i;
        }
        return -1;
    }
}