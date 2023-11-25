class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int prefix[]= new int[n];
        int suffix[]= new int[n];

        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];

        for(int i = 1; i < n ; i++)
        {
            prefix[i] = nums[i] + prefix[i-1];
            suffix[n-i-1] = nums[n-i-1] + suffix[n-i];
        }

        int result[]= new int[n];
        for(int i = 0; i < n; i++)
        {
            result[i] = ((nums[i] * i) - prefix[i]) + (suffix[i] - (nums[i] * (n - i - 1)));
        }
        return result;
    }
}