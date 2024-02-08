class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 1);
        int hash[] = new int[n + 1];
        int max = 1;
        int start = 0;
        for(int i = 0 ; i < n; i++)
        {
            hash[i] = i;
            for(int prevIdx = 0; prevIdx < i; prevIdx++)
            {
                if( nums[i] % nums[prevIdx]  == 0  && dp[i] < dp[prevIdx] + 1)
                {
                    dp[i] = 1 + dp[prevIdx]; 
                    hash[i] = prevIdx;
                    if(dp[i] > max)
                    {
                        max = dp[i];
                        start = i;
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[start]);
        while(hash[start] != start)
        {
            ans.add(nums[hash[start]]);
            start = hash[start];
        }
        return ans;
    }
}