class Solution {
    public int specialTriplets(int[] nums) {
        HashMap<Integer,Integer> r = new HashMap<>();
        HashMap<Integer,Integer> l = new HashMap<>();

        for(int i: nums){
            r.put(i, r.getOrDefault(i, 0) + 1);
        }
        long ans = 0;
        int mod = (int) 1e9 + 7;
        for(int i = 0; i < nums.length; i++){
            int mid = nums[i];
            r.put(mid, r.get(mid) - 1);
            int left = l.getOrDefault(mid * 2, 0);
            int right = r.getOrDefault(mid * 2, 0);
            ans = (ans + (1L *left * right)) % mod;
            l.put(mid, l.getOrDefault(mid, 0) + 1);
        }
        return (int)ans;
    }
}