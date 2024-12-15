class Solution {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int i = 0, j = 0, max = 0, min = (int)1e9, count = 0;

        for(j = 0; j < n; j++){
            max = Math.max(max, nums[j]);
            min = Math.min(min, nums[j]);

            if(max - min > 2)
            {
                long size = j - i;
                ans += (size * (size + 1)) / 2;
                i = j;
                max = nums[j];
                min = nums[j];

                while(i- 1 >= 0 && Math.abs(nums[i - 1]-nums[j]) <= 2){
                    i--;
                    max = Math.max(max, nums[i]);
                    min = Math.min(min, nums[i]);
                }
                if(i < j){
                    size = j - i;
                    ans -= (size * (size + 1)) / 2;
                }
            }   
        }
        long size = j - i;
        ans += (size * (size + 1)) / 2;
        return ans;
    }
}
