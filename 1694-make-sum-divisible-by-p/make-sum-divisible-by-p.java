class Solution {
    public int minSubarray(int[] nums, int p) {
        long n = nums.length;
        long sum = 0;
        for(int i: nums) sum += i;

        if(sum % p == 0) return 0;

        long needed = sum % p;
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0L, -1);

        long curSum = 0;
        long minLength = n;
        for(int i = 0; i < n; i++)
        {
            curSum += nums[i];
            long curMod =curSum % p;
            long targetMod = (curMod - needed + p) % p;

            if(map.containsKey(targetMod)){
                minLength = Math.min(minLength, i - map.get(targetMod));
            }
            map.put(curMod, i);
        }
        return (minLength == n ? -1 : (int) minLength);
    }
}