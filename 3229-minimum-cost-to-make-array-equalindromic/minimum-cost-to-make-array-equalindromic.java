class Solution {
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int num1 = getPalindrome1(median);
        int num2 = getPalindrome2(median);

        long getTotalCost1 = solve(num1, nums);
        long getTotalCost2 = solve(num2, nums);

        return (getTotalCost1 < getTotalCost2 ? getTotalCost1 :getTotalCost2); 
    }
    public int getPalindrome1(int mid)
    {
        int n = mid;
        while(!isPalindrome(n))
        {
            n--;
        }
        return n;
    }
    public int getPalindrome2(int mid)
    {
        int n = mid;
        while(!isPalindrome(n))
        {
            n++;
        }
        return n;
    }
    public long solve(int x,int[] nums)
    {
        long cost = 0;
        for(int i: nums)
        {
            cost += (long)Math.abs(x - i);
        }
        return cost;
    }
    public boolean isPalindrome(int n)
    {
        int temp = n;
        int sum = 0;
        while(temp != 0)
        {
            int rem = (temp % 10);
            sum = sum * 10 + rem;
            temp /= 10;
        }
        return (sum == n);
    }
}