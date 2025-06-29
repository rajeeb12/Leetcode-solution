class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, mod = (int)1e9 + 7;
        int pow[] = new int[n];
        pow[0] = 1;
        for(int i = 1; i < n; i++){
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        int l = 0, r = n - 1, ans = 0;
        while(l <= r){
            if(nums[l] + nums[r] > target){
                r--;
            }else{
                ans = (ans + pow[r - l]) % mod;
                l++; 
            }
        }
        return ans;
    }
}