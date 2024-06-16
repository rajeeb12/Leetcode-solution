class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long maxReachable = 1;
        int index = 0;
        while(maxReachable <= n){
            if(index < nums.length && maxReachable >= nums[index]){
                maxReachable += nums[index];
                index++;
            }else{
                patches++;
                maxReachable += (maxReachable);
            }
        }
        return patches;
    }
}