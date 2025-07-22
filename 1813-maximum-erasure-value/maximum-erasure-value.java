class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i = 0, j = 0, max = 0, sum = 0;
        int map[] = new int[(int)1e5];

        while(j < nums.length){
            map[nums[j]]++;
            sum += nums[j];
            while(map[nums[j]] > 1){
                map[nums[i]]--;
                sum -= nums[i];
                i++;
            }
            j++;
            max = Math.max(max, sum);
        }
        return max;

    }
}