class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int mod = (int)1e9 + 7;
        int pow[] = new int[n];
        pow[0] = 1;
        for(int i = 1 ; i < n ; i++)
        {
            pow[i] = (pow[i - 1] * 2) % mod;
        }
        int left = 0 , right = n - 1;
        int res = 0;
        while(left <= right)
        {
            if(nums[left] + nums[right] > target)
            {
                right--;
            }
            else{
                res = (res + pow[right - left]) % mod;
                left++;
            }
        }
        return res;
    }
}