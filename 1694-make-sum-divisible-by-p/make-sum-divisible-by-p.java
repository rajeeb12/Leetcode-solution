class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for(int i: nums) sum += i;
        
        if(sum % p == 0) return 0;
        if(sum < p) return -1;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int eliminate = (int) (sum % p);
        int csum = 0;
        int ans = n;
        for(int i = 0; i < n; i++)
        {
            csum = (csum + nums[i]) % p;
            map.put(csum, i);
            int want = (csum - eliminate + p) % p;
            ans = Math.min(ans , i - map.getOrDefault(want , -n));
        }

        return (ans < n ? ans : -1);
    }
}