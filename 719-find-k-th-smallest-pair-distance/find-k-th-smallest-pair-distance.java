class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int max = 0;
        int n = nums.length;

        for(int i : nums) max = Math.max(i, max);
        
        int map[] = new int[max + 1];

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                map[Math.abs(nums[i] - nums[j])]++;
            }
        }
        int i;
        for(i = 0 ; i <= max; i++){
            k -= map[i];
            if(k <= 0) break;
        }
        return i; 
    }
}