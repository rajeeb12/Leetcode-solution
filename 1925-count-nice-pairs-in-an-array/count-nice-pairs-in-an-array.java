class Solution {
    public int countNicePairs(int[] nums) {
        int mod = (int)1e9 + 7;
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int count = 0; 
        for(int i = 0 ; i < n; i++){
            int reverse = rev(nums[i]);
            int cal= (reverse - nums[i]);

            count = ((count + map.getOrDefault(cal, 0)) % mod);
            map.put(cal, map.getOrDefault(cal,0) + 1);

        }
        return count % mod;
    }
    public int rev(int x){
        int res = 0;

        while(x != 0){
            int rem = x % 10;
            res = res * 10 + rem;
            x /= 10;
        }
        return res;
    }
}