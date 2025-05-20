class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int map[] = new int[n + 1];

        for(int q[] : queries){
            map[q[0]] += 1;
            map[q[1] + 1] -= 1;
        }

        for(int i = 1; i < n + 1; i++){
            map[i] = map[i] + map[i - 1];
        }

        for(int i = 0; i < n; i++){
            nums[i] = (nums[i] - map[i] < 0 ? 0 : nums[i] - map[i]);
            if(nums[i] != 0) return false;
        }
        return true;
    }
}