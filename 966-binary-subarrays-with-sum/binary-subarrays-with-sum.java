class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return solve(nums, goal) - solve(nums, goal - 1);
    }
    // subarraycount(goal1 + goal2) - subarraycount(goal1) => goal2
    public int solve(int nums[], int goal)
    {
        int sum = 0;
        int count = 0;
        int i = 0;
        for(int j = 0 ; j < nums.length; j++)
        {
            sum += nums[j];

            while(i <= j && sum > goal)
            {
                sum -= nums[i];
                i++;
            }

            count += (j - i + 1);
        } 
        return count;
    }
}