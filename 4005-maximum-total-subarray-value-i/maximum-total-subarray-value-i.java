class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = 0, min = (int)1e9;
        
        for(int i: nums){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        long ans = (max - min) * 1L * k;
        return ans;
    }
}