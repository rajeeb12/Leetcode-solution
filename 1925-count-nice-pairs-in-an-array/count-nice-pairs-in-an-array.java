class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Long,Integer> map = new HashMap<>();
        int mod = (int)1e9 + 7;
        for(int i : nums)
        {
            long reverse = rev(i);
            long sum = i - reverse;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        long ans = 0;
        for(long i: map.values())
        {
            long temp = (i * (i - 1)) / 2;
            ans = (ans + temp) % mod;
        }
        return (int)ans;
    }
    public long rev(int n)
    {
        long sum = 0;
        while(n > 0){
            int rem = n % 10;
            sum = sum * 10 + rem;
            n /= 10;
        }
        return sum;
    }
}