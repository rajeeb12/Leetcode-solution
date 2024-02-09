class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp,1);
        int hash[] = new int[n + 1];
        int max = 1;
        int start = 0;

        for(int i = 0; i < n; i++)
        {
            hash[i] = i;
            for(int pi = 0; pi < i; pi++)
            {
                if(nums[i] % nums[pi] == 0)
                {
                    if(dp[i] < dp[pi] + 1)
                    {
                        dp[i] = dp[pi] + 1;
                        hash[i] = pi;
                        if(max < dp[i])
                        {
                            max = dp[i];
                            start = i;
                        }
                    }
                }
            }
        } 
        List<Integer> ans = new ArrayList<>();

        ans.add(nums[start]);

        while(hash[start] != start)
        {
            ans.add(0,nums[hash[start]]);
            start = hash[start];
        }
        return ans;
    }
}